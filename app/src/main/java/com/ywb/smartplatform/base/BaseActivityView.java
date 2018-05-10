package com.ywb.smartplatform.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * 描述：BaseActivity类实现BaseActivityView接口，
 *      View接口继承BaseActivityView接口
 *  presenter拿到view的引用后，就能使用BaseActivity重写的BaseActivityView中的方法
 * 作者：ywb
 * 日期：2018/5/10 10:18
 */

public interface BaseActivityView {

  void showToast(String msg);

  void startNewActivity(@NonNull Class<?> clz) ;

  void startNewActivity(@NonNull Class<?> clz, Bundle bundle) ;

  void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode);

}
