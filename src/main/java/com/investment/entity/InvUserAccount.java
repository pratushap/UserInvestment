package com.investment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inv_user_account", indexes = {
        @Index(name = "fk_ua_usr_idx", columnList = "user_id")
})
public class InvUserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_num", nullable = false)
    private Integer accountNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private InvUser invUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invUserAccount")
    List<InvPortfolio> invPortfolio = new ArrayList<>();

    public Integer getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    public InvUser getInvUser() {
        return invUser;
    }

    public void setInvUser(InvUser invUser) {
        this.invUser = invUser;
    }

    public List<InvPortfolio> getInvPortfolio() {
        return invPortfolio;
    }

    public void setInvPortfolio(List<InvPortfolio> invPortfolio) {
        this.invPortfolio = invPortfolio;
    }
}