package com.investment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inv_portfolio", indexes = {
        @Index(name = "fk_pf_uacc_idx", columnList = "account_num")
})
public class InvPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id", nullable = false)
    private Integer portfolioId;

    @Column(name = "portfolio_name", length = 45)
    private String portfolioName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invPortfolio")
    List<InvPortfolioStock> invPortfolioStocks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "account_num")
    private InvUserAccount invUserAccount;

    public InvUserAccount getInvUserAccount() {
        return invUserAccount;
    }

    public List<InvPortfolioStock> getInvPortfolioStocks() {
        return invPortfolioStocks;
    }

    public void setInvPortfolioStocks(List<InvPortfolioStock> invPortfolioStocks) {
        this.invPortfolioStocks = invPortfolioStocks;
    }

    public void setInvUserAccount(InvUserAccount invUserAccount) {
        this.invUserAccount = invUserAccount;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }
}