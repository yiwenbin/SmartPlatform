package com.zbiti.module_news.presenter.home;

import android.util.Log;
import com.example.apk.retrofit.RetrofitServiceCreate;
import com.zbiti.module_news.contract.home.ZhihuFragmentContract;
import com.zbiti.module_news.model.zhihu.ZhihuDailyItemBean;
import com.zbiti.module_news.model.zhihu.ZhihuDailyListBean;
import com.zbiti.module_news.retrofit_interface.ZhihuSrvice;
import com.zbiti.smart_platform_base.utils.AppUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by ywb on 2018/4/24.
 */

public class ZhihuFragmentPresenterImpl extends ZhihuFragmentContract.ZhihuFragmentPresenter {

  @Override
  public void loadNews() {
    ZhihuSrvice zhihuSrvice = RetrofitServiceCreate
        .createdService(ZhihuSrvice.class, AppUtils.getContext(),ZhihuSrvice.HOST);
    Observable<ZhihuDailyListBean> dailyListBeanObservable = zhihuSrvice.getLastDailyList();
    rxManager.doObserver(dailyListBeanObservable,
        new Consumer<ZhihuDailyListBean>() {
          @Override
          public void accept(ZhihuDailyListBean zhihuDailyListBean) throws Exception {
            view.displayNews(zhihuDailyListBean.getStories());
          }
        }, new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            Log.i("zhihuThrowable", throwable.toString());
          }
        });
  }


  @Override
  public void loadMore() {

  }

  @Override
  public void onItemClick(int position, ZhihuDailyItemBean zhihuDailyItemBean) {

  }
}
