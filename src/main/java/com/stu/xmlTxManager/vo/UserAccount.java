package com.stu.xmlTxManager.vo;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/11/9.
 */
public class UserAccount {
    private int id;
    private String userId;
    private BigDecimal balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
