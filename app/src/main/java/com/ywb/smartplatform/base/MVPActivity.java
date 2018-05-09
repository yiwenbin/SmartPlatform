package com.ywb.smartplatform.base;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ywb on 2018/4/18.
 * v和p自动关联,自动解开
 */

public abstract class MVPActivity< P extends BaseRxPresenter> extends BaseActivity {

  protected P presenter;

  @Override
  protected void onCreate(Bundle arg) {
    super.onCreate(arg);
    presenter = createPresenter();
    presenter.attachView(this);
    onPresenterPrepare();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }

  protected abstract P createPresenter();

  protected abstract void onPresenterPrepare();

  protected abstract void initData(Intent data);

}
