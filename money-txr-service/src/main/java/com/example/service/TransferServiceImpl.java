package com.example.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service
public class TransferServiceImpl implements TransferService {

	private static Logger logger = Logger.getLogger("transfer-service");

	private AccountRepository accountRepository;

	@Autowired
	public TransferServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TransferServiceImpl instance created...");
	}

	@Transactional
	public void transfer(double amount, String fromAccNum, String toAccNum) {

		logger.info("transfer intiated.");

		Account fromAccount = accountRepository.findById(fromAccNum).get();
		Account toAccount = accountRepository.findById(toAccNum).get();

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.save(fromAccount);
		accountRepository.save(fromAccount);

		logger.info("transfer finished.");

	}

}
