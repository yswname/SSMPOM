package cn.com.demo.ssm.entity;

public class ICardEntity {
    private int icId;
    private String icCode;
    private String icAddress;

    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getIcId() {
        return icId;
    }

    public void setIcId(int icId) {
        this.icId = icId;
    }

    public String getIcCode() {
        return icCode;
    }

    public void setIcCode(String icCode) {
        this.icCode = icCode;
    }

    public String getIcAddress() {
        return icAddress;
    }

    public void setIcAddress(String icAddress) {
        this.icAddress = icAddress;
    }
}
