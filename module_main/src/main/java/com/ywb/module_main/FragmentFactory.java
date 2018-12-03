package com.ywb.module_main;


import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zbiti.smart_platform_base.constants.ARouterConfig;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ywb on 2018/4/18.
 */

public class FragmentFactory {

  /**
   * 已经创建的fragment
   */
  private static Map<Integer, Fragment> mFragments = new HashMap<>();

  public static final int HomeFragmentCode = 0;
  public static final int ShopFragmentCode = 1;
  public static final int MessageFragmentCode = 2;
  public static final int FriendsCircleFragmentCode = 3;
  public static final int MineFragmentCode = 4;
  public static final int ZhihuFragmentCode = 5;
  public static final int JinriFragmentCode = 6;
  public static final int DoubanFragmentCode = 7;


  public static Fragment createFragment(int fragmentCode) {
    Fragment fragment = mFragments.get(fragmentCode);
    if (fragment!=null){
      return fragment;
    }
    switch (fragmentCode){
      case HomeFragmentCode:
        fragment = (Fragment) ARouter.getInstance()
            .build(ARouterConfig.NEWS_FRAGMENT)
            .navigation();
        break;
//      case ShopFragmentCode:
//        fragment = new ShopFragment();
//        break;
//      case MessageFragmentCode:
//        fragment = new MessageFragment();
//        break;
//      case FriendsCircleFragmentCode:
//        fragment = new FriendsCircleFragment();
//        break;
//      case MineFragmentCode:
//        fragment = new MineFragment();
//        break;
//      case ZhihuFragmentCode:
//        fragment = new ZhihuFragment();
//        break;
//      case JinriFragmentCode:
//        fragment = new JinriFragment();
//        break;
//      case DoubanFragmentCode:
//        fragment = new DoubanFragment();
//        break;

      default:
        break;

    }
    if (fragment!=null){
      mFragments.put(fragmentCode, fragment);
    }
    return fragment;
  }

}
