package com.zbiti.module_news.view.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zbiti.module_news.R;
import com.zbiti.smart_platform_base.base.MVPFragment;
import com.zbiti.module_news.contract.home.ZhihuFragmentContract.ZhihuFragmentPresenter;
import com.zbiti.module_news.contract.home.ZhihuFragmentContract.ZhihuFragmentView;
import com.zbiti.module_news.model.zhihu.ZhihuDailyItemBean;
import com.zbiti.module_news.presenter.home.ZhihuFragmentPresenterImpl;
import com.zbiti.module_news.view.adapter.ZhihuFragmentAdapter;
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
