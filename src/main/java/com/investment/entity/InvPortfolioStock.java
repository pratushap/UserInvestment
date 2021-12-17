package com.investment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "inv_portfolio_stocks", indexes = {
        @Index(name = "fk_ps_pf_idx", columnList = "portfolio_id")
})
public class InvPortfolioStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pf_stock_id", nullable = false)
    private Integer pfStockId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private InvPortfolio invPortfolio;

    @Column(name = "stock_name", length = 45)
    private String stockName;

    @Column(name = "curr_stock_price")
    private Integer currStockPrice;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "value")
    private Integer value;

    public Integer getPfStockId() {
        return pfStockId;
    }

    public void setPfStockId(Integer pfStockId) {
        this.pfStockId = pfStockId;
    }

    public InvPortfolio getInvPortfolio() {
        return invPortfolio;
    }

    public void setInvPortfolio(InvPortfolio invPortfolio) {
        this.invPortfolio = invPortfolio;
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