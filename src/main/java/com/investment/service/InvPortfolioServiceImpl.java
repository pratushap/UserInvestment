package com.investment.service;

import com.investment.entity.InvPortfolioStock;
import com.investment.entity.InvUser;
import com.investment.entity.InvUserAccount;
import com.investment.exceptions.ResourceNotFoundException;
import com.investment.model.InvPortfolioStockDto;
import com.investment.repo.InvPortfolioStockRepository;
import com.investment.repo.InvUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvPortfolioServiceImpl implements InvPortfolioService {

    private static final Logger logger = LoggerFactory.getLogger(InvPortfolioServiceImpl.class);


    @Autowired
    InvUserRepository invUserRepository;
    
    @Autowired
    InvPortfolioStockRepository invPortfolioStockRepository;
    
    StringBuilder message=null;

    @Override
    public void saveUserPortfolio(Integer userId, Integer accountId, InvPortfolioStock invPortfolioStock) 
    {
    	message= new StringBuilder();
    	InvUser invUser = invUserRepository
                .findById(userId)
                            .orElseThrow(()-> {
                            	message.append(userId).append(" ").append("User Info not Found");
                                logger.error(message.toString());
                                return  new ResourceNotFoundException(message.toString());
                            }
                    );
    	
    	if(!CollectionUtils.isEmpty(invUser.getInvUserAccount())) { 
    		for (InvUserAccount invUserAccount : invUser.getInvUserAccount())
    			{
                if (invUserAccount.getAccountId().equals(accountId))
                {
                	if(invUserAccount.getBalance() > (invPortfolioStock.getPurchasePrice() * invPortfolioStock.getStockQuantity()))
                	{
                		invPortfolioStockRepository.save(invPortfolioStock);
                	}
                	else {
                		message.append("Order failed due to insufficient balance");
                        logger.error(message.toString());
                        throw new ResourceNotFoundException(message.toString());
                    }	
                }
    		}
    	}
    	else {
    		message.append("User Account info not Found");
            logger.error(message.toString());
            throw   new ResourceNotFoundException(message.toString());
        }
    }
}
