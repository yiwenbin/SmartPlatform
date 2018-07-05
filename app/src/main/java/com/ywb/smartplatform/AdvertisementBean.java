package com.ywb.smartplatform;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ywb on 2018/3/9.
 */

public class AdvertisementBean implements Serializable {

  /**
   * 生成序列号标识
   */
  private static final long serialVersionUID = -208350801443301445L;

  private List<AdConfigsBean> adConfigs;

  public List<AdConfigsBean> getAdConfigs() {
    return adConfigs;
  }

  public void setAdConfigs(List<AdConfigsBean> adConfigs) {
    this.adConfigs = adConfigs;
  }

  public static class AdConfigsBean implements Serializable{

    /**
     * imgName : 屏幕快照 2018-03-26 11.02.33.png
     * adAddr : https://www.baidu.com
     * offsetTime : 2018-03-31 14:44:26
     * cityCode : 320000
     * imgPath : adconfig/320000/
     * name : 测试广告
     * id : 6465ffcee70d4d84b667d37b34df7dc3
     * onsetTime : 2018-03-26 14:44:22
     * intervalTime : 3
     */

    private String imgName;
    private String adAddr;
    private String offsetTime;
    private String cityCode;
    private String imgPath;
    private String name;
    private String id;
    private String onsetTime;
    private int intervalTime;

    public String getImgName() {
      return imgName;
    }

    public void setImgName(String imgName) {
      this.imgName = imgName;
    }

    public String getAdAddr() {
      return adAddr;
    }

    public void setAdAddr(String adAddr) {
      this.adAddr = adAddr;
    }

    public String getOffsetTime() {
      return offsetTime;
    }

    public void setOffsetTime(String offsetTime) {
      this.offsetTime = offsetTime;
    }

    public String getCityCode() {
      return cityCode;
    }

    public void setCityCode(String cityCode) {
      this.cityCode = cityCode;
    }

    public String getImgPath() {
      return imgPath;
    }

    public void setImgPath(String imgPath) {
      this.imgPath = imgPath;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getOnsetTime() {
      return onsetTime;
    }

    public void setOnsetTime(String onsetTime) {
      this.onsetTime = onsetTime;
    }

    public int getIntervalTime() {
      return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
      this.intervalTime = intervalTime;
    }
  }
}
