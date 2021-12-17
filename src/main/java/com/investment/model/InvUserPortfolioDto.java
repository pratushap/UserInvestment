package com.investment.model;


import java.io.Serializable;

public class InvUserPortfolioDto implements Serializable {

    public InvUserPortfolioDto() {
    }

    private  Integer portfolioId;
    private  String portfolioName;
    private  Integer accountNumId;

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Integer getAccountNumId() {
        return accountNumId;
    }

    public void setAccountNumId(Integer accountNumId) {
        this.accountNumId = accountNumId;
    }
}
