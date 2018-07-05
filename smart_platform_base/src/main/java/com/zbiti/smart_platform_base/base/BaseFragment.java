package com.zbiti.smart_platform_base.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ywb on 2018/4/19.
 * 最基本的fragment,可以在此之上封装一层通用的ui样式
 */

public abstract class BaseFragment extends Fragment {

  protected Activity activity ;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.activity = (Activity)context;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(getContentView(), container, false);
    afterSetContentView();
    return v;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    findViews(getView());
    setListeners();
    initData(getArguments());
  }


  /**
   * 设置页面布局
   */
  protected abstract int getContentView();

  /**
   * 获取控件
   */
  protected abstract void findViews(View v);

  /**
   * 设置监听
   */
  protected abstract void setListeners();

  /**
   * 初始化页面数据
   */
  protected abstract void initData(Bundle data);

  /**
   * 紧跟onCreateView之后的工作
   */
  protected void afterSetContentView() {

  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

}
