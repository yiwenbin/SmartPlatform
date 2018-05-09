package com.example.apk.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ywb on 2018/5/2.
 * 使用rxJava的工具类
 */

public class RxManager {

  private CompositeDisposable mCompositeDisposable = new CompositeDisposable();// 管理订阅者者

  public void register(Disposable d) {
    mCompositeDisposable.add(d);
  }

  public void unSubscribe() {
    if (!mCompositeDisposable.isDisposed()){
      mCompositeDisposable.dispose();
    }
  }

  /**
   * 不会自动解除注册
   * @param upstream
   * @param observer
   * @param <T>
   */
  public <T> void doObserver(Observable<T> upstream,Observer<T> observer){
    upstream.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer);
  }

  public <T> void doObserver(Observable<T> upstream,Consumer<T> consumerSuccess,Consumer<Throwable> consumerError){
    Disposable subscribe = upstream.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(consumerSuccess,consumerError);
    register(subscribe);
  }
}
