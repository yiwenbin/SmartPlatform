package com.zbiti.module_news.presenter.home;

import com.zbiti.module_news.contract.home.DoubanFragmentContract.DoubanFragmentPresenter;

/**
 * Created by ywb on 2018/4/24.
 */

public class DoubanFragmentPresenterImpl extends DoubanFragmentPresenter{

  @Override
  public void loadNews() {

    view.displayNews();
  }

  @Override
  public void loadMore() {

  }
}
