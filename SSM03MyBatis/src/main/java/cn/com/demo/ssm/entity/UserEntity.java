package cn.com.demo.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {
    private int urId;
    private String urName;
    private String urUserName;
    private int urAge;

    private List<OrderEntity> orderList = new ArrayList<>();

    private ICardEntity card;

    public List<OrderEntity> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderEntity> orderList) {
        this.orderList = orderList;
    }

    public ICardEntity getCard() {
        return card;
    }

    public void setCard(ICardEntity card) {
        this.card = card;
    }

    public int getUrId() {
        return urId;
    }

    public void setUrId(int urId) {
        this.urId = urId;
    }

    public String getUrName() {
        return urName;
    }

    public void setUrName(String urName) {
        this.urName = urName;
    }

    public String getUrUserName() {
        return urUserName;
    }

    public void setUrUserName(String urUserName) {
        this.urUserName = urUserName;
    }

    public int getUrAge() {
        return urAge;
    }

    public void setUrAge(int urAge) {
        this.urAge = urAge;
    }
}
