package com.ywb.smartplatform.contract.home;

import com.ywb.smartplatform.base.BaseRxPresenter;
import com.ywb.smartplatform.model.zhihu.ZhihuDailyItemBean;
import java.util.ArrayList;


/**
 * Created by ywb on 2018/4/24.
 */

public interface ZhihuFragmentContract {

  interface ZhihuFragmentView{
    void displayNews(ArrayList<ZhihuDailyItemBean> itemBeans);
    void newsDetail();
  }

  abstract class ZhihuFragmentPresenter extends BaseRxPresenter<ZhihuFragmentView> {

    public abstract void loadNews();

    public abstract void loadMore();

    public abstract void onItemClick(int position, ZhihuDailyItemBean zhihuDailyItemBean);
  }
}
