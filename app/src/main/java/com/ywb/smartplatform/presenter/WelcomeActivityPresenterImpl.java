package com.ywb.smartplatform.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.example.apk.retrofit.RetrofitServiceCreate;
import com.example.apk.utils.AppUtils;
import com.ywb.smartplatform.contract.WelcomeActivityContract.WelcomeActivityPresenter;
import com.ywb.smartplatform.model.AdvertisementBean.AdConfigsBean;
import com.ywb.smartplatform.retrofit_interface.WelcomeService;
import com.ywb.smartplatform.utils.LocaCacheUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.ResponseBody;

/**
 * Created by ywb on 2018/5/3.
 * 模拟广告
 */

public class WelcomeActivityPresenterImpl extends WelcomeActivityPresenter {

  private String advPictureDir;
  private String advObjecteDir;
  private final String advName = "advCache";
  private AdConfigsBean adConfigsBean;
  private Bitmap advBitmap = null;
  private final String testBaseUrl = "http://c.hiphotos.baidu.com/";
  private final String testPicUrl = "image/pic/item/e1fe9925bc315c609e11bbb781b1cb13485477e6.jpg";
  private String adnvertisementUrl = null;

  @Override
  public void initAdvertisement() {
    advPictureDir = AppUtils.getContext().getExternalFilesDir(Environment.DIRECTORY_DCIM)
        .getAbsolutePath();
    advObjecteDir = AppUtils.getContext().getCacheDir().getAbsolutePath();
    getAdvertisementFromCache();
  }

  private void getAdvertisementFromCache() {
    advBitmap = getBitmapFromLocal(advName);
    if (advBitmap != null) {
      view.showAdvertisement(advBitmap, adnvertisementUrl);
      startCountDown(3);
    } else {
      view.gotoMain();
      getAdvertisementFromNet();
    }
  }

  /**
   * 需要在子线程执行，而且不能随着activity的destory而中止
   */
  private void getAdvertisementFromNet() {
    WelcomeService welcomeService = RetrofitServiceCreate
        .createdService(WelcomeService.class,testBaseUrl);
    Observable<ResponseBody> advertisementBitmap = welcomeService.getAdvertisementBitmap(
        testPicUrl);
    advertisementBitmap.
        subscribeOn(Schedulers.io())    //完全执行在子线程
        .subscribe(new Observer<ResponseBody>() {
          Disposable disposable;

          @Override
          public void onSubscribe(Disposable d) {
            disposable = d;
          }

          @Override
          public void onNext(ResponseBody value) {
            Bitmap bitmap = BitmapFactory.decodeStream(value.byteStream());
            saveAdvertisementCache(bitmap);
          }

          @Override
          public void onError(Throwable e) {
            disposable.dispose();
          }

          @Override
          public void onComplete() {
            disposable.dispose();
          }
        });
  }

  /**
   * 倒计时
   * todo 此页面两种rxjava需要封装1.可以中止 2.运行结束后自动十方
   */
  private void startCountDown(final int count) {
    Observable.interval(1, TimeUnit.SECONDS)
        .take(count+1)//计时次数
        .map(new Function<Long, Integer>() {
          @Override
          public Integer apply(Long along) throws Exception {
            int time = (int) (count - along);
            return time;
          }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Integer>() {
          Disposable disposable;

          @Override
          public void onSubscribe(Disposable d) {
            disposable = d;
          }

          @Override
          public void onNext(Integer value) {
            view.setCountDown(value);
          }

          @Override
          public void onError(Throwable e) {
            disposable.dispose();
          }

          @Override
          public void onComplete() {
            if (!cancleCount){
              view.gotoMain();
            }
            disposable.dispose();
          }
        });

  }

  private boolean cancleCount = false;
  @Override
  public void stopCountDowm() {
    cancleCount = true;
  }

  private Bitmap getBitmapFromLocal(String id) {
    try {
      File file = new File(advPictureDir, id);
      if (file.exists()) {
        Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(
            file));
        return bitmap;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private void saveAdvertisementCache(Bitmap bitmap) {
    LocaCacheUtils.saveBitmapCache(bitmap, advPictureDir, advName);
  }

  @Override
  protected void onDetach() {
    super.onDetach();
    if (advBitmap != null) {
      advBitmap.recycle();
      advBitmap = null;
    }
  }
}
