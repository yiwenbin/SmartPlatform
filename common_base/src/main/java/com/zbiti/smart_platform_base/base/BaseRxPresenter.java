package com.zbiti.smart_platform_base.base;

import com.zbiti.smart_platform_base.rxjava.RxManager;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by ywb on 2018/4/17.
 * 用弱引用指向activity
 */

public abstract class BaseRxPresenter<V> {

  protected Reference<V> mViewRef;
  protected V view;
  protected RxManager rxManager = new RxManager();

  public void attachView(V view) {
    mViewRef = new WeakReference<V>(view);
    this.view = mViewRef.get();
    onAttach();
  }

  public V getView() {
    if (mViewRef == null) {
      return null;
    }
    return mViewRef.get();
  }

  public boolean isViewAttached() {
    return mViewRef != null && mViewRef.get() != null;
  }

  public void detachView() {
    if (rxManager!=null){
      rxManager.unSubscribe();
    }
    if (mViewRef != null) {
      mViewRef.clear();
      mViewRef = null;
    }
    onDetach();
  }

  protected void onAttach(){}

  protected void onDetach(){}
}
