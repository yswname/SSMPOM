package cn.com.demo.ssm.snacks.xml.entity;

import java.io.Serializable;

public class FoodsEntity implements Serializable {
    private Integer fdId;

    private String fdName;

    private Double fdPrice;

    private String fdTaste;

    private String fdPackage;

    private Integer fdInventory;

    private String fdDetail;

    private static final long serialVersionUID = 1L;

    public Integer getFdId() {
        return fdId;
    }

    public void setFdId(Integer fdId) {
        this.fdId = fdId;
    }

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName == null ? null : fdName.trim();
    }

    public Double getFdPrice() {
        return fdPrice;
    }

    public void setFdPrice(Double fdPrice) {
        this.fdPrice = fdPrice;
    }

    public String getFdTaste() {
        return fdTaste;
    }

    public void setFdTaste(String fdTaste) {
        this.fdTaste = fdTaste == null ? null : fdTaste.trim();
    }

    public String getFdPackage() {
        return fdPackage;
    }

    public void setFdPackage(String fdPackage) {
        this.fdPackage = fdPackage == null ? null : fdPackage.trim();
    }

    public Integer getFdInventory() {
        return fdInventory;
    }

    public void setFdInventory(Integer fdInventory) {
        this.fdInventory = fdInventory;
    }

    public String getFdDetail() {
        return fdDetail;
    }

    public void setFdDetail(String fdDetail) {
        this.fdDetail = fdDetail == null ? null : fdDetail.trim();
    }
}