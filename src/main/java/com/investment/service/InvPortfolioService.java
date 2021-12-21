package com.investment.service;

import com.investment.entity.InvPortfolioStock;

public interface InvPortfolioService {
	void saveUserPortfolio(Integer userId, Integer accountId, InvPortfolioStock invPortfolioStock);
}
