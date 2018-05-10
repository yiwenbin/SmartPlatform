package com.ywb.smartplatform.contract;

import android.graphics.Bitmap;
import com.ywb.smartplatform.base.BaseActivityView;
import com.ywb.smartplatform.base.BaseRxPresenter;

/**
 * Created by ywb on 2018/5/3.
 * 包含v和p的接口,写在一起方便阅读
 * todo module也抽取成一层，与presenter解耦
 */

public interface WelcomeActivityContract {

  interface WelcomeActiityView extends BaseActivityView{
    void showAdvertisement(Bitmap bitmap, String url);
    void setCountDown(int count);
    void gotoMain();
  }

  abstract class WelcomeActivityPresenter extends BaseRxPresenter<WelcomeActiityView>{
    public abstract void initAdvertisement();
    public abstract void stopCountDowm();
  }

}
