package com.zbiti.atmos_bridge;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * 描述：
 * 作者：ywb
 * 日期：2018/5/16 16:56
 */

public class BaseWebview extends WebView {

  public BaseWebview(Context context) {
    this(context,null);
  }

  public BaseWebview(Context context, AttributeSet attrs) {
    super(context,attrs);

    this.setVerticalScrollBarEnabled(false);
    this.setHorizontalScrollBarEnabled(false);
    this.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.getSettings().setJavaScriptEnabled(true);
    this.getSettings().setSupportZoom(true);
    this.getSettings().setBuiltInZoomControls(true);
    this.getSettings().setUseWideViewPort(true);
    this.getSettings().setLoadWithOverviewMode(true);
    this.getSettings().setAppCacheEnabled(true);
    this.getSettings().setDomStorageEnabled(true);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
  }
}
