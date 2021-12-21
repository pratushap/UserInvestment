package com.investment.entity;

import javax.persistence.*;

@Entity
@Table(name = "portfolio", indexes = {
        @Index(name = "fk_pf_uacc_idx", columnList = "account_id")
})
public class InvPortfolioStock {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "stock_name")
    private String stockName;
    
    @Column(name = "stock_quantity")
    private int stockQuantity;
    
    @Column(name = "stock_price")
    private Double purchasePrice;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private InvUserAccount invUserAccount;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public InvUserAccount getInvUserAccount() {
		return invUserAccount;
	}

	public void setInvUserAccount(InvUserAccount invUserAccount) {
		this.invUserAccount = invUserAccount;
	}

  
}