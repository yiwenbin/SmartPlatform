package com.zbiti.module_news.contract.home;

import com.zbiti.smart_platform_base.base.BaseRxPresenter;

/**
 * Created by ywb on 2018/4/24.
 */

public interface DoubanFragmentContract {

  interface DoubanFragmentView{
    void displayNews();
    void newsDetail();
  }

  abstract class DoubanFragmentPresenter extends BaseRxPresenter<DoubanFragmentView> {
    public abstract void loadNews();
    public abstract void loadMore();
  }

}
