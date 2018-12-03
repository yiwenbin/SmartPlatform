package com.zbiti.module_news.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.zbiti.module_news.R;
import com.zbiti.smart_platform_base.base.MVPFragment;
import com.zbiti.module_news.contract.HomeFragmentContract.HomeFragmentPresenter;
import com.zbiti.module_news.contract.HomeFragmentContract.HomeFragmentView;
import com.zbiti.module_news.presenter.HomeFragmentPresenterImpl;
import com.zbiti.module_news.view.adapter.HomeFragmentPagerAdapter;
import com.zbiti.smart_platform_base.constants.ARouterConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ywb on 2018/4/19.
 */
@Route(path = ARouterConfig.NEWS_FRAGMENT)
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
