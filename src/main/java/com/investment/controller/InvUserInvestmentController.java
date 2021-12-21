package com.investment.controller;

import com.investment.entity.InvPortfolioStock;
import com.investment.service.InvPortfolioService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class InvUserInvestmentController {

    @Autowired
    InvPortfolioService invPortfolioService;

    @PostMapping("/{userId}/accounts/{accountId}/stocks")
    public ResponseEntity<String> saveUserPortfolio(@PathVariable Integer userId, @PathVariable Integer accountId, 
    	@Valid	@RequestBody InvPortfolioStock invPortfolioStock)
    {
    	invPortfolioService.saveUserPortfolio(userId,accountId,invPortfolioStock);       
        return new ResponseEntity<>("Order successful", HttpStatus.OK);
    }

}
