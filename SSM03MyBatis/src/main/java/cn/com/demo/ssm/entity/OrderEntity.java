package cn.com.demo.ssm.entity;

public class OrderEntity {
    private int odId;
    private String odName;
    private int odUrId;

    private UserEntity user;

    public int getOdId() {
        return odId;
    }

    public void setOdId(int odId) {
        this.odId = odId;
    }

    public String getOdName() {
        return odName;
    }

    public void setOdName(String odName) {
        this.odName = odName;
    }

    public int getOdUrId() {
        return odUrId;
    }

    public void setOdUrId(int odUrId) {
        this.odUrId = odUrId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
