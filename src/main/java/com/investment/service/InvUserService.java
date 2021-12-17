package com.investment.service;

import com.investment.model.InvPortfolioDto;

public interface InvUserService {

    InvPortfolioDto findByUserIdByAccountNum(Integer userId, Integer accountNum);
}
