package com.investment.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "account", indexes = {
        @Index(name = "fk_ua_usr_idx", columnList = "user_id")
})
public class InvUserAccount {
	@Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
	
    @Column(name = "account_number", nullable = false)
    private Long accountNumber;

    @Column(name = "account_balance")
    private Double balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invUserAccount")
    List<InvPortfolioStock> invPortfolioStock;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<InvPortfolioStock> getInvPortfolioStock() {
		return invPortfolioStock;
	}

	public void setInvPortfolioStock(List<InvPortfolioStock> invPortfolioStock) {
		this.invPortfolioStock = invPortfolioStock;
	}

   
}