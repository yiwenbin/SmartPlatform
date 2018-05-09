package com.example.apk.retrofit;

import com.example.apk.okhttp.OkhttpClientHelper;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ywb on 2018/5/1.
 * 如果项目baseUrl是固定的,可以将Retrofit改为单例
 */

public class RetrofitServiceCreate {
  public static <T> T createdService(Class<T> clazz,String url){
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(url)
        .client(new OkhttpClientHelper().getOkHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(clazz);
  }

}
