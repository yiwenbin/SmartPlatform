package com.zbiti.smart_platform_base.global;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


/**
 * Created by ywb on 2018/4/30.
 *
 */
public class MyApplication extends Application {
    protected static Context context;
    protected static RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);
        context = getApplicationContext();
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
