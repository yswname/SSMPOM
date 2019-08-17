package cn.com.demo.ssm.snacks.entity;

import java.io.Serializable;
import java.util.Date;

public class PromotionEntity implements Serializable {
    private Integer prmId;

    private String prmName;

    private Date prmStartTime;

    private Date prmEndTime;

    private Double prmDiscount;

    private String prmDetail;

    private static final long serialVersionUID = 1L;

    public Integer getPrmId() {
        return prmId;
    }

    public void setPrmId(Integer prmId) {
        this.prmId = prmId;
    }

    public String getPrmName() {
        return prmName;
    }

    public void setPrmName(String prmName) {
        this.prmName = prmName == null ? null : prmName.trim();
    }

    public Date getPrmStartTime() {
        return prmStartTime;
    }

    public void setPrmStartTime(Date prmStartTime) {
        this.prmStartTime = prmStartTime;
    }

    public Date getPrmEndTime() {
        return prmEndTime;
    }

    public void setPrmEndTime(Date prmEndTime) {
        this.prmEndTime = prmEndTime;
    }

    public Double getPrmDiscount() {
        return prmDiscount;
    }

    public void setPrmDiscount(Double prmDiscount) {
        this.prmDiscount = prmDiscount;
    }

    public String getPrmDetail() {
        return prmDetail;
    }

    public void setPrmDetail(String prmDetail) {
        this.prmDetail = prmDetail == null ? null : prmDetail.trim();
    }
}