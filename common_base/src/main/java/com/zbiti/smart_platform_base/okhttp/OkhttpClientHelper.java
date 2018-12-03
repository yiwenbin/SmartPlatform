package com.zbiti.smart_platform_base.okhttp;

import android.content.Context;
import com.zbiti.smart_platform_base.BuildConfig;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ywb on 2018/4/30.
 */

public class OkhttpClientHelper {

  private Cache cache;


  public OkHttpClient getOkHttpClient(Context context) {
    if (cache==null){
      File chachefile = new File(context.getExternalCacheDir(), "Cache");
      cache = new Cache(chachefile, 1024 * 1024 * 20);
    }

    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    /**
     * log信息拦截器
     */
    if (BuildConfig.DEBUG) {
      //log信息拦截器
      HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      builder.addInterceptor(httpLoggingInterceptor);
    }
    //https

    //缓存
    builder.addNetworkInterceptor(new InterceptorCache(context))
        .addInterceptor(new InterceptorCache(context))
        .cache(cache);

    //公共参数
//    builder.addInterceptor(new InterceptorQueryParameter());
    //设置超时
    builder.connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS);
    //错误重连
    builder.retryOnConnectionFailure(true);

    return builder.build();
  }
}
