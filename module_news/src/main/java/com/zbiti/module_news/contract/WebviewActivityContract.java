package com.zbiti.module_news.contract;

import com.zbiti.smart_platform_base.base.BaseActivityView;
import com.zbiti.smart_platform_base.base.BaseRxPresenter;

/**
 * 描述：
 * 作者：ywb
 * 日期：2018/5/16 15:13
 */

public interface WebviewActivityContract {

  interface WebviewActivityView extends BaseActivityView{

    void showDetaileUrl(String url);
    /**
     * 显示网络错误
     */
    void showNetworkError();

  }

  abstract class WebviewActivityPresenter extends BaseRxPresenter<WebviewActivityView>{

    /**
     * 加载新闻详情
     *
     * @param url url
     */
    public abstract void loadDetailWithUrl(String url);


  }

}
