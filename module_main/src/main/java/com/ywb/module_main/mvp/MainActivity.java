package com.ywb.module_main.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import com.ywb.module_main.FragmentFactory;
import com.ywb.module_main.FragmentHelper;
import com.ywb.module_main.R;
import com.ywb.module_main.helper.BottomNavigationViewHelper;
import com.ywb.module_main.mvp.presenter.MainActivityContract.MainActivityPresenter;
import com.ywb.module_main.mvp.presenter.MainActivityContract.MainActivityView;
import com.ywb.module_main.mvp.presenter.MainActivityPresenterImpl;
import com.zbiti.smart_platform_base.base.MVPActivity;

/**
 * Created by ywb on 2018/4/17.
 *
 */

public class MainActivity extends MVPActivity<MainActivityPresenter> implements
    MainActivityView {

  private BottomNavigationView bottomNavigationView;
  private FragmentManager fragmentManager;
  private FragmentHelper fragmentHelper;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected MainActivityPresenter createPresenter() {
    return new MainActivityPresenterImpl();
  }

  @Override
  protected void onPresenterPrepare() {

  }


  @Override
  protected int getContentView() {
    return R.layout.activity_main;
  }

  @Override
  protected void findViews() {
    bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_bnv);
  }

  @Override
  protected void setListeners() {
    bottomNavigationView.setOnNavigationItemSelectedListener(
        new OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int i = item.getItemId();
            if (i == R.id.menu_item_home) {
              switchFragmnet(FragmentFactory.HomeFragmentCode);

            } else if (i == R.id.menu_item_shop) {
              switchFragmnet(FragmentFactory.ShopFragmentCode);

            } else if (i == R.id.menu_item_message) {
              switchFragmnet(FragmentFactory.MessageFragmentCode);

            } else if (i == R.id.menu_item_friends_circle) {
              switchFragmnet(FragmentFactory.FriendsCircleFragmentCode);

            } else if (i == R.id.menu_item_personal) {
              switchFragmnet(FragmentFactory.MineFragmentCode);

            }
            return true;
          }
        });
  }

  @Override
  protected void initData(Intent data) {
    BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    fragmentManager = getSupportFragmentManager();
    fragmentHelper = new FragmentHelper(fragmentManager);
    switchFragmnet(FragmentFactory.HomeFragmentCode);
  }


  @Override
  public void switchFragmnet(int fragmentCode) {
    Fragment fragment = FragmentFactory.createFragment(fragmentCode);
    fragmentHelper.showFragment(fragment,R.id.fl_container);
  }
}
