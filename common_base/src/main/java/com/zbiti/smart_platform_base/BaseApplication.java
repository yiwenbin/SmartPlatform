package com.zbiti.smart_platform_base;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * 描述：
 * 作者：ywb 日期：2018/12/3 10:52
 */
public class BaseApplication extends Application {

  private static Application application;
  protected static RefWatcher refWatcher;
  protected static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    application = this;
    context = getApplicationContext();
    initARouter();

    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return;
    }
    refWatcher = LeakCanary.install(this);
  }

  private void initARouter() {
    if (BuildConfig.DEBUG) {
      ARouter.openLog();  // 打印日志
      ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
    }
    ARouter.init(application);// 尽可能早，推荐在Application中初始化
  }




  /**
   * 获取上下文对象
   *
   * @return context
   */
  public static Context getContext() {
    return context;
  }

  public static RefWatcher getRefWatcher() {
    return refWatcher;
  }

}
