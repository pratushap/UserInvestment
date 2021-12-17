package com.investment.model;

import java.io.Serializable;

public class InvPortfolioStockDto implements Serializable {

   // private  Integer pfStockId;
  //  private  Integer portfolioId;
   // private  String portfolioPortfolioName;
    private  String stockName;
    private  Integer currStockPrice;
    private  Integer qty;
    private  Integer value;

    public InvPortfolioStockDto() {
    }

/*
    public Integer getPfStockId() {
        return pfStockId;
    }

    public void setPfStockId(Integer pfStockId) {
        this.pfStockId = pfStockId;
    }

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioPortfolioName() {
        return portfolioPortfolioName;
    }

    public void setPortfolioPortfolioName(String portfolioPortfolioName) {
        this.portfolioPortfolioName = portfolioPortfolioName;
    }
*/

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getCurrStockPrice() {
        return currStockPrice;
    }

    public void setCurrStockPrice(Integer currStockPrice) {
        this.currStockPrice = currStockPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
