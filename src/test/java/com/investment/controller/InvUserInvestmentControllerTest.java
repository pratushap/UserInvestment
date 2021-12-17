package com.investment.controller;

import com.investment.model.InvPortfolioDto;
import com.investment.service.InvUserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
@Import(InvUserInvestmentController.class)

public class InvUserInvestmentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private InvUserServiceImpl invUserService;

    private  InvPortfolioDto invPortfolioDto;

    @Before
    public void setup(){
        invPortfolioDto = new InvPortfolioDto();
        invPortfolioDto.setPortfolioId(1);
    }

    @After
    public void tearDown() {
        invPortfolioDto=null;
    }

    @Test
    public void findByProductNameOrProductBrandTest() throws Exception {

        Mockito.when(this.invUserService.findByUserIdByAccountNum(1,1))
                .thenReturn(invPortfolioDto);
        this.mockMvc.perform(get("/api/users/1/accounts/1/portfolios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.portfolioId", is(1)));
    }
}