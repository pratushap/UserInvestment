package com.investment.repo;

import com.investment.entity.InvPortfolioStock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvPortfolioStockRepository extends JpaRepository<InvPortfolioStock, Integer> {


}