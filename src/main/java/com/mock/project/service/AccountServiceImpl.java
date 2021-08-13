package com.mock.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.entity.Account;
import com.mock.project.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	UserRepository userrepository;

	@Override
	public Account getOne(String username) {
		// TODO Auto-generated method stub
		return userrepository.findByusername(username);
	}
	@Override
	public void save(Account account) {
		userrepository.save(account);
	}
}
