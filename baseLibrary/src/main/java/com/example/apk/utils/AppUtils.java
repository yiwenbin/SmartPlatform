package com.example.apk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.example.apk.global.GlobalApplication;

/**
 * Created by ywb on 2018/5/1.
 */

public class AppUtils {

  public static Context getContext(){
    return GlobalApplication.getContext();
  }

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
