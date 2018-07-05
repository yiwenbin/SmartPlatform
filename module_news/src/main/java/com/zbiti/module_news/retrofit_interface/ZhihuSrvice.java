package com.zbiti.module_news.retrofit_interface;

import com.zbiti.module_news.model.zhihu.ZhihuDailyDetailBean;
import com.zbiti.module_news.model.zhihu.ZhihuDailyListBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ywb on 2018/4/28.
 */

public interface ZhihuSrvice {

  String HOST = "http://news-at.zhihu.com";

  @GET("/api/4/news/latest")
  Observable<ZhihuDailyListBean> getLastDailyList();

  @GET("/api/4/news/before/{date}")
  Observable<ZhihuDailyListBean> getDailyListWithDate(@Path("date") String date);

  @GET("/api/4/news/{id}")
  Observable<ZhihuDailyDetailBean> getZhihuDailyDetail(@Path("id") String id);

}
