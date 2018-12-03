package com.zbiti.smart_platform_base.okhttp;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ywb on 2018/4/30.
 * 添加公共参数拦截器,或者设置请求头
 * 如果项目的接口有公共的参数,添加在拦截器里面
 */

public class InterceptorQueryParameter implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {

    Request originalRequest = chain.request();
    Request request;
    String method = originalRequest.method();
    Headers headers = originalRequest.headers();
    HttpUrl modifiedUrl = originalRequest.url().newBuilder()
        // Provide your custom parameter here
        .addQueryParameter("platform", "adnroid")
        .addQueryParameter("version", "1.2.0")
        .build();
    request = originalRequest.newBuilder().url(modifiedUrl).build();
    return chain.proceed(request);
  }
}
