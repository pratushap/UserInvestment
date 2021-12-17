package com.investment.service;

import com.investment.entity.InvPortfolio;
import com.investment.entity.InvPortfolioStock;
import com.investment.entity.InvUser;
import com.investment.entity.InvUserAccount;
import com.investment.exceptions.ResourceNotFoundException;
import com.investment.model.InvPortfolioDto;
import com.investment.model.InvPortfolioStockDto;
import com.investment.repo.InvUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvUserServiceImpl implements InvUserService {

    private static final Logger logger = LoggerFactory.getLogger(InvUserServiceImpl.class);


    @Autowired
    InvUserRepository invUserRepository;
    StringBuilder errorMessage=null;

    @Override
    public InvPortfolioDto findByUserIdByAccountNum(Integer userId, Integer accountNum) {
        InvPortfolioDto invPortfolioDto = null;
        InvPortfolioStockDto invPortfolioStockDto = null;
        List<InvPortfolioStockDto> invPortfolioStockDtos = new ArrayList<>();
        errorMessage= new StringBuilder();

        InvUser invUser = invUserRepository
                                    .findById(userId)
                                                .orElseThrow(()-> {
                                                    errorMessage.append(userId).append(" ").append("User Info not Found");
                                                    logger.error(errorMessage.toString());
                                                    return  new ResourceNotFoundException(errorMessage.toString());
                                                }
                                        );

        if(!CollectionUtils.isEmpty(invUser.getInvUserAccounts())) {

            for (InvUserAccount invUserAccount : invUser.getInvUserAccounts()) {
                if (invUserAccount.getAccountNum().equals(accountNum)){
                    for (InvPortfolio invPortfolio : invUserAccount.getInvPortfolio()) {
                        invPortfolioDto = new InvPortfolioDto();
                        invPortfolioDto.setAccountNumId(accountNum);
                        invPortfolioDto.setPortfolioId(invPortfolio.getPortfolioId());
                        invPortfolioDto.setPortfolioName(invPortfolio.getPortfolioName());
                        for (InvPortfolioStock invPortfolioStock : invPortfolio.getInvPortfolioStocks()) {
                            invPortfolioStockDto = new InvPortfolioStockDto();
                            invPortfolioStockDto.setStockName(invPortfolioStock.getStockName());
                            invPortfolioStockDto.setCurrStockPrice(invPortfolioStock.getCurrStockPrice());
                            invPortfolioStockDto.setQty(invPortfolioStock.getQty());
                            invPortfolioStockDto.setValue(invPortfolioStock.getValue());
                            invPortfolioStockDtos.add(invPortfolioStockDto);
                        }
                        invPortfolioDto.setInvPortfolioStockDtos(invPortfolioStockDtos);
                    }
            }else {
                        errorMessage.append(accountNum).append(" ").append("User Account Portfolio info not Found");
                        logger.error(errorMessage.toString());
                        throw   new ResourceNotFoundException(errorMessage.toString());
                }

            }
        }else {
            errorMessage.append(" ").append("User Accounts info not Found");
            logger.error(errorMessage.toString());
            throw   new ResourceNotFoundException(errorMessage.toString());
        }
        return invPortfolioDto;
    }
}
