package com.zbiti.smart_platform_base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 描述：
 * 作者：ywb
 * 日期：2018/7/5 14:31
 */

public class NetUtil {

  /**
   * 判断是否有网络
   *
   * @return 返回值
   */
  public static boolean isNetworkConnected(Context context) {
    if (context != null) {
      ConnectivityManager mConnectivityManager = (ConnectivityManager) context
          .getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

      if (mNetworkInfo != null) {
        return mNetworkInfo.isAvailable();
      }
    }
    return false;
  }

}
