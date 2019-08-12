package cn.com.demo.ssm.mybatis.entity;

public class SnFoods {
    private int fdId;
    private String fdName;
    private double fdPrice;
    private String fdTaste;
    private String fdPackage;
    private int fdInventory;
    private String fdDetail;

    public int getFdId() {
        return fdId;
    }

    public void setFdId(int fdId) {
        this.fdId = fdId;
    }

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName;
    }

    public double getFdPrice() {
        return fdPrice;
    }

    public void setFdPrice(double fdPrice) {
        this.fdPrice = fdPrice;
    }

    public String getFdTaste() {
        return fdTaste;
    }

    public void setFdTaste(String fdTaste) {
        this.fdTaste = fdTaste;
    }

    public String getFdPackage() {
        return fdPackage;
    }

    public void setFdPackage(String fdPackage) {
        this.fdPackage = fdPackage;
    }

    public int getFdInventory() {
        return fdInventory;
    }

    public void setFdInventory(int fdInventory) {
        this.fdInventory = fdInventory;
    }

    public String getFdDetail() {
        return fdDetail;
    }

    public void setFdDetail(String fdDetail) {
        this.fdDetail = fdDetail;
    }

    @Override
    public String toString() {
        return "SnFoods{" +
                "fdId=" + fdId +
                ", fdName='" + fdName + '\'' +
                ", fdPrice=" + fdPrice +
                ", fdTaste='" + fdTaste + '\'' +
                ", fdPackage='" + fdPackage + '\'' +
                ", fdInventory=" + fdInventory +
                ", fdDetail='" + fdDetail + '\'' +
                '}';
    }
}
