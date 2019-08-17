package cn.com.demo.ssm.snacks.xml.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderEntity implements Serializable {
    private Integer odId;

    private String odCode;

    private Date odTime;

    private Integer odUrId;

    private String odReceiverName;

    private String odReceiverPhone;

    private String odReceiverAddress;

    private Integer odStatus;

    private static final long serialVersionUID = 1L;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getOdCode() {
        return odCode;
    }

    public void setOdCode(String odCode) {
        this.odCode = odCode == null ? null : odCode.trim();
    }

    public Date getOdTime() {
        return odTime;
    }

    public void setOdTime(Date odTime) {
        this.odTime = odTime;
    }

    public Integer getOdUrId() {
        return odUrId;
    }

    public void setOdUrId(Integer odUrId) {
        this.odUrId = odUrId;
    }

    public String getOdReceiverName() {
        return odReceiverName;
    }

    public void setOdReceiverName(String odReceiverName) {
        this.odReceiverName = odReceiverName == null ? null : odReceiverName.trim();
    }

    public String getOdReceiverPhone() {
        return odReceiverPhone;
    }

    public void setOdReceiverPhone(String odReceiverPhone) {
        this.odReceiverPhone = odReceiverPhone == null ? null : odReceiverPhone.trim();
    }

    public String getOdReceiverAddress() {
        return odReceiverAddress;
    }

    public void setOdReceiverAddress(String odReceiverAddress) {
        this.odReceiverAddress = odReceiverAddress == null ? null : odReceiverAddress.trim();
    }

    public Integer getOdStatus() {
        return odStatus;
    }

    public void setOdStatus(Integer odStatus) {
        this.odStatus = odStatus;
    }
}