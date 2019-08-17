package cn.com.demo.ssm.snacks.entity;

import java.io.Serializable;

public class OrderItemEntity implements Serializable {
    private Integer odItId;

    private Integer odItFdId;

    private Integer odItCount;

    private Double odItPrice;

    private Integer odId;

    private static final long serialVersionUID = 1L;

    public Integer getOdItId() {
        return odItId;
    }

    public void setOdItId(Integer odItId) {
        this.odItId = odItId;
    }

    public Integer getOdItFdId() {
        return odItFdId;
    }

    public void setOdItFdId(Integer odItFdId) {
        this.odItFdId = odItFdId;
    }

    public Integer getOdItCount() {
        return odItCount;
    }

    public void setOdItCount(Integer odItCount) {
        this.odItCount = odItCount;
    }

    public Double getOdItPrice() {
        return odItPrice;
    }

    public void setOdItPrice(Double odItPrice) {
        this.odItPrice = odItPrice;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }
}