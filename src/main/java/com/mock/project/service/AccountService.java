package com.mock.project.service;

import com.mock.project.entity.Account;

public interface AccountService {
	Account getOne(String username);
	
	void save(Account account);
}
