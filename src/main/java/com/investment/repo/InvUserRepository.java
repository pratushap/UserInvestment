package com.investment.repo;

import com.investment.entity.InvUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvUserRepository extends JpaRepository<InvUser, Integer> {
}