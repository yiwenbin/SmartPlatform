package com.zbiti.module_news.model.zhihu;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by ywb on 2018/4/24.
 * "@SerializedName("top_stories")" 注解,在gson解析的时候,将变量名top_stories对应本地的mZhihuDailyItems
 * <p>
 */
public class ZhihuDailyListBean {
    @SerializedName("date")
    private String date;
    @SerializedName("top_stories")
    private ArrayList<ZhihuDailyItemBean> mZhihuDailyItems;
    @SerializedName("stories")
    private ArrayList<ZhihuDailyItemBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ZhihuDailyItemBean> getZhihuDailyItems() {
        return mZhihuDailyItems;
    }

    public void setZhihuDailyItems(ArrayList<ZhihuDailyItemBean> zhihuDailyItems) {
        this.mZhihuDailyItems = zhihuDailyItems;
    }

    public ArrayList<ZhihuDailyItemBean> getStories() {
        return stories;
    }

    public void setStories(ArrayList<ZhihuDailyItemBean> stories) {
        this.stories = stories;
    }

    @Override
    public String toString() {
        return "ZhihuDailyListBean{" +
                "date='" + date + '\'' +
                ", mZhihuDailyItems=" + mZhihuDailyItems +
                ", stories=" + stories +
                '}';
    }
}
