package com.investment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class InvUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", length = 45)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    List<InvUserAccount> invUserAccount;

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

	public List<InvUserAccount> getInvUserAccount() {
		return invUserAccount;
	}

	public void setInvUserAccount(List<InvUserAccount> invUserAccount) {
		this.invUserAccount = invUserAccount;
	}

   
}