package com.ywb.smartplatform.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ywb.smartplatform.R;
import com.ywb.smartplatform.base.MVPActivity;
import com.ywb.smartplatform.contract.WelcomeActivityContract.WelcomeActiityView;
import com.ywb.smartplatform.contract.WelcomeActivityContract.WelcomeActivityPresenter;
import com.ywb.smartplatform.presenter.WelcomeActivityPresenterImpl;

/**
 * Created by ywb on 2018/4/24.
 * 广告页
 */

public class WelcomeActivity extends MVPActivity<WelcomeActivityPresenter> implements
    WelcomeActiityView {

  private final int COUNT_MESSAGE = 6;
  private final String COUNT_TIME_KEY = "count time key";
  private boolean countDownSwitch = true;
  private TextView tvCountDown;
  private LinearLayout llGotoMain;
  private ImageView ivAdvertisement;


  @Override
  protected int getContentView() {
    return R.layout.activity_welcome;
  }

  @Override
  protected void findViews() {
    tvCountDown = (TextView) findViewById(R.id.tv_count_down);
    llGotoMain = (LinearLayout) findViewById(R.id.ll_jump_to_main);
    ivAdvertisement = (ImageView) findViewById(R.id.iv_advertisement);
  }

  @Override
  protected void setListeners() {
    llGotoMain.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        gotoMain();
        presenter.stopCountDowm();
      }
    });
  }

  @Override
  protected void initData(Intent data) {

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected WelcomeActivityPresenter createPresenter() {
    return new WelcomeActivityPresenterImpl();
  }

  @Override
  protected void onPresenterPrepare() {
    presenter.initAdvertisement();
  }

  /**
   * 开始倒计时
   * @param count
   */
  @Override
  public void setCountDown(int count){
    if (llGotoMain.getVisibility() !=View.VISIBLE){
      llGotoMain.setVisibility(View.VISIBLE);
    }
    if (tvCountDown != null){
      String s = String.valueOf(count);
      tvCountDown.setText(s.isEmpty()? "" : s);
    }

  }

  @Override
  public void showAdvertisement(Bitmap bitmap, final String url) {
    ivAdvertisement.setClickable(true);
    ivAdvertisement.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        gotoAdvertisementDetail(url);
      }
    });
    ivAdvertisement.setImageBitmap(bitmap);
  }

  @Override
  public void gotoMain() {
    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
    startActivity(intent);
    finish();
  }

  public void gotoAdvertisementDetail(String url) {
    // TODO: 2018/4/24 广告页,webviwe
//    stopCountDown();
//    Intent intentMain = new Intent(WelcomeActivity.this,MainActivity.class);
//    Intent intentAdv = new Intent(WelcomeActivity.this,AdvertisementActivity.class);
//    intentAdv.putExtra(AdvertisementActivity.ADV_URK_KEY,url);
//    Intent[] intents = {intentMain,intentAdv};
//    startActivities(intents);
//    finish();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    presenter.stopCountDowm();
  }
}
