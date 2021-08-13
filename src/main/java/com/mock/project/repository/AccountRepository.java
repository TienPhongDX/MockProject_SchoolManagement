package com.mock.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.project.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	
}
