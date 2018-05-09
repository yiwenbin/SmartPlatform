package com.ywb.smartplatform.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ywb on 2018/4/17.
 * 项目中最基础的activity基类,可以在这个基类之后再定制一层,统一的界面格式封装
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentView());
    afterSetContentView(savedInstanceState);
    findViews();
    setListeners();
    initData(getIntent());
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    boolean granted = true;
    for (int i = 0; i < grantResults.length; i++) {
      if (!(PackageManager.PERMISSION_GRANTED == grantResults[i])) {
        granted = false;
        break;
      }
    }
    if (granted) {//权限均被同意
      onPermissionGranted(requestCode);
    } else {
      boolean deniedEver = false;//是否在拒绝系统权限提示的同时勾选了不再提示(永久拒绝)
      for (int i = 0; i < permissions.length; i++) {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {
          deniedEver = true;
          break;
        }
      }
      if (deniedEver) {//权限被永久拒绝
        onPermissionDenied();
      } else {
        onPermissionDeniedOnce();
      }
    }
  }

  /**
   * 总布局
   */
  protected abstract int getContentView();

  /**
   * 加载控件
   */
  protected abstract void findViews();

  /**
   * 设置监听
   */
  protected abstract void setListeners();

  /**
   * 初始化页面数据
   */
  protected abstract void initData(Intent data);


  /**
   * setContentView及findViews之间的工作，可包含对savedInstanceState的处理
   */
  protected void afterSetContentView(@Nullable Bundle savedInstanceState) {

  }

  /**
   * 检查权限，有则直接执行后续操作，无则走请求权限流程
   */
  public final void checkPermissions(int requestCode, @NonNull String... permissions) {
    if (hasPermissions(permissions)) {
      onPermissionGranted(requestCode);
    } else {
      ActivityCompat.requestPermissions(this, permissions, requestCode);
    }
  }

  /**
   * 获取到权限的回调
   */
  protected void onPermissionGranted(int requestCode) {

  }

  /**
   * 权限被永久拒绝的回调，默认给出提示框，并提供前往系统权限修改页面的跳转
   */
  protected void onPermissionDenied() {
    deniedEverDialog(deniedEverMessage(), deniedEverPositive(), deniedEverNegative());
  }

  /**
   * 权限被拒绝的回调
   */
  protected void onPermissionDeniedOnce() {
  }


  /**
   * 永久拒绝提示语句
   */
  protected String deniedEverMessage() {
    return "必要权限已被禁止，为了保障您的正常体验，请前往应用信息页面开启权限。";
  }

  /**
   * 永久拒绝跳转文字
   */
  protected String deniedEverPositive() {
    return "前往";
  }

  /**
   * 永久拒绝取消文字
   */
  protected String deniedEverNegative() {
    return "取消";
  }

  /**
   * 判断是否具有权限
   *
   * @param permissions 权限列表
   * @return true:全部都具有
   */
  private boolean hasPermissions(@NonNull String... permissions) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
      return true;
    }
    for (String permission : permissions) {
      if (ContextCompat.checkSelfPermission(this, permission)
          != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }

  /**
   * 永久拒绝提示框
   */
  private void deniedEverDialog(String message, String positive, String negative) {
    new AlertDialog.Builder(this).setMessage(message)
        .setPositiveButton(positive, new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            gotoSettings();
          }
        })
        .setNegativeButton(negative, new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        }).show();
  }

  /**
   * 跳转到系统的应用信息页面
   */
  private void gotoSettings() {
    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
    Uri uri = Uri.fromParts("package", getPackageName(), null);
    intent.setData(uri);
    startActivity(intent);
  }
}
