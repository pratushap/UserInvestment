package com.investment.repo;

import com.investment.entity.InvPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvPortfolioRepository extends JpaRepository<InvPortfolio, Integer> {

}