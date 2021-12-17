package com.investment.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InvPortfolioDto implements Serializable {

    public InvPortfolioDto() {
    }

    private  Integer portfolioId;
    private  String portfolioName;
    private  Integer accountNumId;

    List<InvPortfolioStockDto> invPortfolioStockDtos= new ArrayList<>();

    public List<InvPortfolioStockDto> getInvPortfolioStockDtos() {
        return invPortfolioStockDtos;
    }

    public void setInvPortfolioStockDtos(List<InvPortfolioStockDto> invPortfolioStockDtos) {
        this.invPortfolioStockDtos = invPortfolioStockDtos;
    }

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
