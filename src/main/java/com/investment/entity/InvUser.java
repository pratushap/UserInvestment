package com.investment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inv_user")
public class InvUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", length = 45)
    private String password;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invUser")
    List<InvUserAccount> invUserAccounts = new ArrayList<>();


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<InvUserAccount> getInvUserAccounts() {
        return invUserAccounts;
    }

    public void setInvUserAccounts(List<InvUserAccount> invUserAccounts) {
        this.invUserAccounts = invUserAccounts;
    }
}