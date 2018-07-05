package com.zbiti.module_news.contract;

import com.zbiti.smart_platform_base.base.BaseActivityView;
import com.zbiti.smart_platform_base.base.BaseRxPresenter;

/**
 * Created by ywb on 2018/4/18.
 *
 */

public interface MainActivityContract {

  interface MainActivityView extends BaseActivityView{
    void switchFragmnet(int fragmentCode );
  }

  /**
   * view中需要使用BasePresenter,所以presenter使用抽象类
   */
  abstract class MainActivityPresenter extends BaseRxPresenter<MainActivityView> {
    public abstract void switchFragmnet(int fragmentCode);
  }

}
