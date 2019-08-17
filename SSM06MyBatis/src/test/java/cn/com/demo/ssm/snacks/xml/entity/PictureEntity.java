package cn.com.demo.ssm.snacks.xml.entity;

import java.io.Serializable;

public class PictureEntity implements Serializable {
    private Integer picId;

    private String picUrl;

    private Integer picType;

    private String picDesc;

    private Integer picFdId;

    private static final long serialVersionUID = 1L;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc == null ? null : picDesc.trim();
    }

    public Integer getPicFdId() {
        return picFdId;
    }

    public void setPicFdId(Integer picFdId) {
        this.picFdId = picFdId;
    }
}