package com.zbiti.module_news.view.fragment.home;

import android.os.Bundle;
import android.view.View;
import com.zbiti.module_news.R;
import com.zbiti.smart_platform_base.base.MVPFragment;
import com.zbiti.module_news.contract.home.DoubanFragmentContract.DoubanFragmentPresenter;
import com.zbiti.module_news.contract.home.DoubanFragmentContract.DoubanFragmentView;
import com.zbiti.module_news.presenter.home.DoubanFragmentPresenterImpl;

/**
 * Created by ywb on 2018/4/24.
 * 豆瓣电影
 */

public class DoubanFragment extends MVPFragment<DoubanFragmentPresenter> implements
    DoubanFragmentView {

  @Override
  protected DoubanFragmentPresenter createPresenter() {
    return new DoubanFragmentPresenterImpl();
  }

  @Override
  protected void onPresenterPrepare() {

  }

  @Override
  protected int getContentView() {
    return R.layout.fragment_news_recycle;
  }

  @Override
  protected void findViews(View v) {

  }

  @Override
  protected void setListeners() {

  }

  @Override
  protected void initData(Bundle data) {

    presenter.loadNews();

  }

  @Override
  public void displayNews() {

  }

  @Override
  public void newsDetail() {

  }
}
