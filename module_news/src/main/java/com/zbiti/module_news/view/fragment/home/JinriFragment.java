package com.zbiti.module_news.view.fragment.home;

import android.os.Bundle;
import android.view.View;
import com.zbiti.module_news.R;
import com.zbiti.smart_platform_base.base.MVPFragment;
import com.zbiti.module_news.contract.home.JinriFragmentContract.JinriFragmentPresenter;
import com.zbiti.module_news.presenter.home.JinriFragmentPresenterImpl;


/**
 * Created by ywb on 2018/4/24.
 * 今日头条
 */

public class JinriFragment extends MVPFragment<JinriFragmentPresenter> {

  @Override
  protected JinriFragmentPresenter createPresenter() {
    return new JinriFragmentPresenterImpl();
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

  }
}
