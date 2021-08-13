package com.mock.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mock.project.entity.Account;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {
	
	Account findByusername(String username);
	
	
}
