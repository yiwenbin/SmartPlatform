package com.ywb.smartplatform.contract;

import android.graphics.Bitmap;
import com.ywb.smartplatform.base.BaseRxPresenter;

/**
 * Created by ywb on 2018/5/3.
 */

public interface WelcomeActivityContract {

  interface WelcomeActiityView{
    void showAdvertisement(Bitmap bitmap, String url);
    void setCountDown(int count);
    void gotoMain();
  }

  abstract class WelcomeActivityPresenter extends BaseRxPresenter<WelcomeActiityView>{
    public abstract void initAdvertisement();
    public abstract void stopCountDowm();
  }

}
