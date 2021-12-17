package com.investment.controller;

import com.investment.model.InvPortfolioDto;
import com.investment.service.InvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class InvUserInvestmentController {

    @Autowired
    InvUserService invUserService;

    @GetMapping("/{userId}/accounts/{accountId}/portfolios")
    public ResponseEntity getUserPortfolio(
            @PathVariable Integer userId, @PathVariable Integer accountId
    ){
        InvPortfolioDto invPortfolioDto =  invUserService.findByUserIdByAccountNum(userId,accountId);

      return   new ResponseEntity<>(invPortfolioDto, HttpStatus.OK);
    }

}
