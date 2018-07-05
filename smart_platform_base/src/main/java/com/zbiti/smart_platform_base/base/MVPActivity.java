package com.zbiti.smart_platform_base.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.zbiti.smart_platform_base.utils.AppUtils;

/**
 * Created by ywb on 2018/4/18.
 * v和p自动关联,自动解开
 */

public abstract class MVPActivity< P extends BaseRxPresenter> extends BaseActivity implements BaseActivityView{

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



  @Override
  public void startNewActivity(@NonNull Class<?> clz) {
    startActivity(new Intent(this, clz));
  }


  @Override
  public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {
    Intent intent = new Intent();
    intent.setClass(this, clz);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
    startActivity(intent);

  }

  @Override
  public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {
    Intent intent = new Intent();
    intent.setClass(this, clz);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
    startActivityForResult(intent, requestCode);
  }

  @Override
  public void showToast(String msg) {
    Toast.makeText(AppUtils.getContext(),msg,Toast.LENGTH_LONG);
  }
}
