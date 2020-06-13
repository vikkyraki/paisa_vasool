package com.fun.paisa.model.split;

import com.fun.paisa.model.User;

public abstract class PriceSplit{

    private User user;
    private Double amount;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
