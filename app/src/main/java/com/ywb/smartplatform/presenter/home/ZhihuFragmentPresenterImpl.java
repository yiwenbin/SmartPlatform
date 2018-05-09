package com.ywb.smartplatform.presenter.home;

import android.util.Log;
import com.example.apk.retrofit.RetrofitServiceCreate;
import com.ywb.smartplatform.contract.home.ZhihuFragmentContract;
import com.ywb.smartplatform.model.zhihu.ZhihuDailyItemBean;
import com.ywb.smartplatform.model.zhihu.ZhihuDailyListBean;
import com.ywb.smartplatform.retrofit_interface.ZhihuSrvice;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by ywb on 2018/4/24.
 */

public class ZhihuFragmentPresenterImpl extends ZhihuFragmentContract.ZhihuFragmentPresenter {

  @Override
  public void loadNews() {
    ZhihuSrvice zhihuSrvice = RetrofitServiceCreate
        .createdService(ZhihuSrvice.class, ZhihuSrvice.HOST);
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
