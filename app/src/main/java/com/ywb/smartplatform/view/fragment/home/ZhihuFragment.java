package com.ywb.smartplatform.view.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ywb.smartplatform.R;
import com.ywb.smartplatform.base.MVPFragment;
import com.ywb.smartplatform.contract.home.ZhihuFragmentContract.ZhihuFragmentPresenter;
import com.ywb.smartplatform.contract.home.ZhihuFragmentContract.ZhihuFragmentView;
import com.ywb.smartplatform.model.zhihu.ZhihuDailyItemBean;
import com.ywb.smartplatform.model.zhihu.ZhihuDailyListBean;
import com.ywb.smartplatform.presenter.home.ZhihuFragmentPresenterImpl;
import com.ywb.smartplatform.view.adapter.ZhihuFragmentAdapter;
import java.util.ArrayList;

/**
 * Created by ywb on 2018/4/24.
 *
 * 知乎头条
 */

public class ZhihuFragment extends MVPFragment<ZhihuFragmentPresenter> implements
    ZhihuFragmentView {

  private RecyclerView rvNews;
  private ZhihuFragmentAdapter rvAdapter;

  @Override
  protected int getContentView() {
    return R.layout.fragment_news_recycle;
  }

  @Override
  protected void findViews(View v) {
    rvNews = (RecyclerView) v.findViewById(R.id.rv_news);
  }

  @Override
  protected void setListeners() {

  }

  @Override
  protected void initData(Bundle data) {
    rvAdapter = new ZhihuFragmentAdapter();
    rvNews.setAdapter(rvAdapter);
    rvNews.setLayoutManager(new LinearLayoutManager(activity));
  }
  @Override
  protected ZhihuFragmentPresenter createPresenter() {
    return new ZhihuFragmentPresenterImpl();
  }

  @Override
  protected void onPresenterPrepare() {
    presenter.loadNews();
  }
  @Override
  public void displayNews(ArrayList<ZhihuDailyItemBean> itemBeans) {
    rvAdapter.setData(itemBeans);
    rvAdapter.notifyDataSetChanged();
  }

  @Override
  public void newsDetail() {

  }
}
