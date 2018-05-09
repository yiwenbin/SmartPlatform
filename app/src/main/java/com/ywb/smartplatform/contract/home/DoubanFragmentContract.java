package com.ywb.smartplatform.contract.home;

import com.ywb.smartplatform.base.BaseRxPresenter;

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
