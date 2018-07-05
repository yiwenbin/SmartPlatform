package com.example.apk.okhttp;

import android.content.Context;
import com.example.apk.NetUtil;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ywb on 2018/4/30.
 * 缓存拦截器,一般缓存信息是写在请求头里面的,如果无法控制请求头里面的缓存信息,那么自己拦截改写.
 * https://blog.csdn.net/briblue/article/details/52920531
 */
public class InterceptorCache implements Interceptor {
    private Context context;

    public InterceptorCache(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        if (NetUtil.isNetworkConnected(context)) {
            // 有网络时, 缓存1小时
            int maxAge = 60 * 60;

            Response response = chain.proceed(request);
            return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, max-age=" + maxAge)
                .build();
        } else {
            // 无网络时，缓存为4周
            int maxStale = 60 * 60 * 24 * 28;
            request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build();
            Response response = chain.proceed(request);
            return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                .build();
        }
    }
}

