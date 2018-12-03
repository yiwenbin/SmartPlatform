package com.ywb.module_main.mvp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ywb.module_main.MainApplication;
import com.ywb.module_main.R;
import com.ywb.module_main.mvp.presenter.WelcomeActivityContract.WelcomeActiityView;
import com.ywb.module_main.mvp.presenter.WelcomeActivityContract.WelcomeActivityPresenter;
import com.ywb.module_main.mvp.presenter.WelcomeActivityPresenterImpl;
import com.zbiti.smart_platform_base.base.MVPActivity;

/**
 * Created by ywb on 2018/4/24.
 * 欢迎页，广告页
 */

public class WelcomeActivity extends MVPActivity<WelcomeActivityPresenter> implements
    WelcomeActiityView {

  private TextView tvCountDown;
  private LinearLayout llJumptoMain;
  private ImageView ivAdvertisement;

  @Override
  protected int getContentView() {
    return R.layout.activity_welcome;
  }

  @Override
  protected void findViews() {
    tvCountDown = (TextView) findViewById(R.id.tv_count_down);
    llJumptoMain = (LinearLayout) findViewById(R.id.ll_jump_to_main);
    ivAdvertisement = (ImageView) findViewById(R.id.iv_advertisement);
  }

  @Override
  protected void setListeners() {
    llJumptoMain.setOnClickListener(new OnClickListener() {
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
    if (llJumptoMain.getVisibility() !=View.VISIBLE){
      llJumptoMain.setVisibility(View.VISIBLE);
    }
    if (tvCountDown != null){
      String s = String.valueOf(count);
      tvCountDown.setText(s.isEmpty()? "" : s);
    }

  }

  @Override
  public void gotoMain() {
    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
    startActivity(intent);
    finish();
  }

  @Override
  public void showAdvertisement(Bitmap bitmap, final String url) {
    if (url!=null&&!url.isEmpty()){
      ivAdvertisement.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          gotoAdvertisementDetail(url);
        }
      });
    }
    ivAdvertisement.setImageBitmap(bitmap);
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
  protected void onDestroy() {
    super.onDestroy();
    MainApplication.getRefWatcher().watch(this);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    presenter.stopCountDowm();//退出后停止倒计时
  }
}
