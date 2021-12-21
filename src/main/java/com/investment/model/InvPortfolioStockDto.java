package com.investment.model;

import java.io.Serializable;

public class InvPortfolioStockDto implements Serializable {
    private  String stockName;
    private  Integer currStockPrice;
    private  Integer qty;
    private  Integer value;

    public InvPortfolioStockDto() {
    }

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
