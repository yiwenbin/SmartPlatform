package com.ywb.smartplatform.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Fragment结合ViewPager通用Adapter
 * Created by ywb on 2018/4/24.
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

  private List<Fragment> fragments;

  public HomeFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
    super(fm);
    this.fragments = fragments;
  }

  @Override
  public Fragment getItem(int position) {
    return fragments.get(position);
  }

  @Override
  public int getCount() {
    return fragments.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    String title = null;
    switch (position){
      case 0:
        title =  "知乎日报";
        break;
      case 1:
        title =  "今日头条";
        break;
      case 2:
        title =  "豆瓣影评";
        break;
    }
    return title;
  }
}
