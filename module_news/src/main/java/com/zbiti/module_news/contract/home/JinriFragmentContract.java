package com.zbiti.module_news.contract.home;

import com.zbiti.smart_platform_base.base.BaseRxPresenter;

/**
 * Created by ywb on 2018/4/24.
 * 今日头条
 */

public interface JinriFragmentContract {

  interface JinriFragmentView{
    void displayNews();
    void newsDetail();
  }

  abstract class JinriFragmentPresenter extends BaseRxPresenter<JinriFragmentView> {
    public abstract void loadNews();
    public abstract void loadMore();
  }

}
