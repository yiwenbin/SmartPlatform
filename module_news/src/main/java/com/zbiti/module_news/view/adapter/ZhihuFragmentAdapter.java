package com.zbiti.module_news.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zbiti.module_news.R;
import com.zbiti.smart_platform_base.utils.AppUtils;

import com.zbiti.module_news.model.zhihu.ZhihuDailyItemBean;
import com.zbiti.module_news.view.adapter.ZhihuFragmentAdapter.Holder;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：知乎日报
 * 作者：ywb
 * 日期：2018/5/7 9:37
 */

public class ZhihuFragmentAdapter extends RecyclerView.Adapter<Holder> {

  private List<ZhihuDailyItemBean> zhihuDailyItemBeans = new ArrayList<>();

  public ZhihuFragmentAdapter() {

  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_recycle_news, parent, false);
    return new Holder(v);
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    ZhihuDailyItemBean zhihuDailyItemBean = zhihuDailyItemBeans.get(position);
    if (zhihuDailyItemBean!=null){
      holder.tvTitle.setText(zhihuDailyItemBean.getTitle());
      Glide.with(AppUtils.getContext()).load(zhihuDailyItemBean.getImages()[0]).crossFade().into(holder.ivTitle);
    }
  }

  @Override
  public int getItemCount() {
    return zhihuDailyItemBeans.size();
  }

  public void setData(List<ZhihuDailyItemBean> data){
    zhihuDailyItemBeans.addAll(data);
  }

  class Holder extends ViewHolder{

    private final ImageView ivTitle;
    private final TextView tvTime;
    private final TextView tvWriter;
    private final TextView tvTitle;

    public Holder(View itemView) {
      super(itemView);
      tvTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
      tvWriter = (TextView) itemView.findViewById(R.id.tv_item_who);
      tvTime = (TextView) itemView.findViewById(R.id.tv_item_time);
      ivTitle = (ImageView) itemView.findViewById(R.id.iv_item_image);
    }
  }
}
