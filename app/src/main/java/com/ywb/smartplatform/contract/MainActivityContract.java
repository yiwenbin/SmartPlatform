package com.ywb.smartplatform.contract;

import com.ywb.smartplatform.base.BaseRxPresenter;

/**
 * Created by ywb on 2018/4/18.
 *
 */

public interface MainActivityContract {

  interface MainActivityView {
    void switchFragmnet(int fragmentCode );
  }

  /**
   * view中需要使用BasePresenter,所以presenter使用抽象类
   */
  abstract class MainActivityPresenter extends BaseRxPresenter<MainActivityView> {
    public abstract void switchFragmnet(int fragmentCode);
  }

}
