package com.example.model;

public class UserPayment {

    private int id;
    private String name;
    private String accountId;
    private int amount;
    private String currency;

    public UserPayment(Integer id, String name, String accountId, int amount, String currency) {
        this.id = id;
        this.name = name;
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
    }


    public int getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
