package cn.com.demo.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class RoleEntity {
    private int rlId;
    private String rlName;

    private List<UserEntity> userList = new ArrayList<UserEntity>();

    public int getRlId() {
        return rlId;
    }

    public void setRlId(int rlId) {
        this.rlId = rlId;
    }

    public String getRlName() {
        return rlName;
    }

    public void setRlName(String rlName) {
        this.rlName = rlName;
    }

    public List<UserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity> userList) {
        this.userList = userList;
    }
}
