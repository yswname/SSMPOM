package cn.com.demo.ssm.snacks.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private Integer urId;

    private String urUserName;

    private String urName;

    private String urPassword;

    private static final long serialVersionUID = 1L;

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public String getUrUserName() {
        return urUserName;
    }

    public void setUrUserName(String urUserName) {
        this.urUserName = urUserName == null ? null : urUserName.trim();
    }

    public String getUrName() {
        return urName;
    }

    public void setUrName(String urName) {
        this.urName = urName == null ? null : urName.trim();
    }

    public String getUrPassword() {
        return urPassword;
    }

    public void setUrPassword(String urPassword) {
        this.urPassword = urPassword == null ? null : urPassword.trim();
    }
}