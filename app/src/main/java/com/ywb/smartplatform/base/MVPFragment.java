package com.ywb.smartplatform.base;

import android.os.Bundle;

/**
 * Created by ywb on 2018/4/23.
 */

public abstract class MVPFragment< P extends BaseRxPresenter> extends BaseFragment {

  protected P presenter;

  @Override
   public void onCreate(Bundle arg) {
    super.onCreate(arg);
    presenter = createPresenter();
    presenter.attachView(this);
    onPresenterPrepare();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }

  protected abstract P createPresenter();

  protected abstract void onPresenterPrepare();

}
