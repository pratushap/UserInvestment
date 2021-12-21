package com.investment.controller;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
import java.util.ArrayList;
import java.util.List;
 
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.investment.entity.InvPortfolioStock;
import com.investment.service.InvPortfolioService;
 
@WebMvcTest
public class InvUserInvestmentControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private InvPortfolioService invPortfolioService;
 
    @LocalServerPort
    private int port;
    
    private static ObjectMapper mapper = new ObjectMapper();
 
    @Test
    public void saveUserPortfolio() throws Exception {
        InvPortfolioStock portfolioStock = new InvPortfolioStock();
        portfolioStock.setOrder_id(5);
        portfolioStock.setStockName("Tesla");
        portfolioStock.setStockQuantity(2);
        portfolioStock.setPurchasePrice(200D);
        Mockito.when(invPortfolioService.saveUserPortfolio(1, 1, portfolioStock)).thenReturn(portfolioStock);
        String json = mapper.writeValueAsString(portfolioStock);
       
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + port + "/api/users/1/accounts/1/stocks")
        		.contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        		.andDo(MockMvcResultHandlers.print())
        		.andExpect(MockMvcResultMatchers.status().isOk())
        		.andExpect(jsonPath("$.order_Id", Matchers.equalTo(5)))
                .andExpect(jsonPath("$.stockName", Matchers.equalTo("Tesla")))
                .andExpect(jsonPath("$.stockQuantity", Matchers.equalTo(2)))
                .andExpect(jsonPath("$.purchasePrice", Matchers.equalTo(200D)));
        
    }
}