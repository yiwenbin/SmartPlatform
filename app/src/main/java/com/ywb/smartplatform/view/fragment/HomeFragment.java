package com.ywb.smartplatform.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.ywb.smartplatform.R;
import com.ywb.smartplatform.base.MVPFragment;
import com.ywb.smartplatform.contract.HomeFragmentContract.HomeFragmentPresenter;
import com.ywb.smartplatform.contract.HomeFragmentContract.HomeFragmentView;
import com.ywb.smartplatform.presenter.HomeFragmentPresenterImpl;
import com.ywb.smartplatform.view.adapter.HomeFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ywb on 2018/4/19.
 */

public class HomeFragment extends MVPFragment<HomeFragmentPresenter> implements HomeFragmentView{

  private Toolbar toolBar;
  private ViewPager viewPager;
  private TabLayout tabLayout;

  @Override
  protected HomeFragmentPresenter createPresenter() {
    return new HomeFragmentPresenterImpl();
  }

  @Override
  protected void onPresenterPrepare() {

  }

  @Override
  protected int getContentView() {
    return R.layout.fragment_home;
  }

  @Override
  protected void findViews(View v) {
    toolBar = (Toolbar) v.findViewById(R.id.tb_fragment_home);
    viewPager = (ViewPager) v.findViewById(R.id.vp_fragment_home);
    tabLayout = (TabLayout) v.findViewById(R.id.tl_tabs);
  }

  @Override
  protected void setListeners() {

  }

  @Override
  protected void initData(Bundle data) {
    toolBar.setTitle("主页");
    List<Fragment> fragments = new ArrayList<>();
    fragments.add(FragmentFactory.createFragment(FragmentFactory.ZhihuFragmentCode));
    fragments.add(FragmentFactory.createFragment(FragmentFactory.JinriFragmentCode));
    fragments.add(FragmentFactory.createFragment(FragmentFactory.DoubanFragmentCode));
    HomeFragmentPagerAdapter pagerAdapter = new HomeFragmentPagerAdapter(
        getChildFragmentManager(), fragments);
    viewPager.setAdapter(pagerAdapter);
    viewPager.setOffscreenPageLimit(2); //设置左右预加载
    tabLayout.setupWithViewPager(viewPager);
  }

}
