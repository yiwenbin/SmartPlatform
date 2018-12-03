package com.ywb.module_main;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * 描述：欢迎页网络请求
 * 作者：ywb
 * 日期：2018/5/4 14:47
 */

public interface WelcomeService {
  @GET
  Observable<ResponseBody> getAdvertisementBitmap(@Url String url);
}
