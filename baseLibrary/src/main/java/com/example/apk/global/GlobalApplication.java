package com.example.apk.global;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;


/**
 * Created by ywb on 2018/4/30.
 *
 */
public class GlobalApplication extends Application {
    protected static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
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
}
