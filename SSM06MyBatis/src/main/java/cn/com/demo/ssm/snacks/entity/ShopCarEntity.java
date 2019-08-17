package cn.com.demo.ssm.snacks.entity;

import java.io.Serializable;
import java.sql.Date;

public class ShopCarEntity implements Serializable {
    private Integer shcId;

    private Integer shcUrId;

    private Integer shcFdId;

    private Integer shcCount;

    private Date shcAddTime;

    private static final long serialVersionUID = 1L;

    public Integer getShcId() {
        return shcId;
    }

    public void setShcId(Integer shcId) {
        this.shcId = shcId;
    }

    public Integer getShcUrId() {
        return shcUrId;
    }

    public void setShcUrId(Integer shcUrId) {
        this.shcUrId = shcUrId;
    }

    public Integer getShcFdId() {
        return shcFdId;
    }

    public void setShcFdId(Integer shcFdId) {
        this.shcFdId = shcFdId;
    }

    public Integer getShcCount() {
        return shcCount;
    }

    public void setShcCount(Integer shcCount) {
        this.shcCount = shcCount;
    }

    public Date getShcAddTime() {
        return shcAddTime;
    }

    public void setShcAddTime(Date shcAddTime) {
        this.shcAddTime = shcAddTime;
    }
}