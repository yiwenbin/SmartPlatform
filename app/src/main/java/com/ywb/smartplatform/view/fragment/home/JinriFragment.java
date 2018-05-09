package com.ywb.smartplatform.view.fragment.home;

import android.os.Bundle;
import android.view.View;
import com.ywb.smartplatform.R;
import com.ywb.smartplatform.base.MVPFragment;
import com.ywb.smartplatform.contract.home.JinriFragmentContract.JinriFragmentPresenter;
import com.ywb.smartplatform.presenter.home.JinriFragmentPresenterImpl;


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
