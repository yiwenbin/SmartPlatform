package com.ywb.module_main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by ywb on 2018/4/23.
 */

public class FragmentHelper {

  private FragmentManager fragmentManager;

  public FragmentHelper(FragmentManager fragmentManager) {
    this.fragmentManager = fragmentManager;
  }

  public void addFragments(int containerId,int showPosition,Fragment... fragments){
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    for (int i = 0; i < fragments.length; i++) {
      Fragment fragment = fragments[i];
      String toName = fragment.getClass().getName();
      transaction.add(containerId, fragment, toName);
      if (i != showPosition) {
        transaction.hide(fragment);
      }
    }
    transaction.commit();
  }

  public void showFragment(@NonNull Fragment fragment,int containerId){
    if (null == fragment){
      return;
    }
    if (fragment.isAdded()){
      if (fragment.isHidden()){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        transaction.show(fragment);
        transaction.commit();
      }
    }else {
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      hideFragments(transaction);
      transaction.add(containerId, fragment);
      transaction.commit();
    }
  }


  private void hideFragments(FragmentTransaction ft) {
    for (Fragment fragment: fragmentManager.getFragments()) {
      if (fragment!=null&&!fragment.isHidden()){
        ft.hide(fragment);
      }
    }
  }
}
