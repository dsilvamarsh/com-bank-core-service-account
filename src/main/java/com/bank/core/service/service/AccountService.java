package com.bank.core.service.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bank.core.service.constants.ExceptionConstants;
import com.bank.core.service.model.Account;
import com.bank.core.service.repository.AccountRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Data
@Log4j2
@Service
public class AccountService {

	private AccountRepository repo;

	public Optional<Account> find(UUID id) throws Exception {

		try {

			return repo.findById(id);

		} catch (Exception e) {
			log.error(ExceptionConstants.EXCEPTION, e);
			throw new Exception(ExceptionConstants.EXCEPTION_DB_FIND);

		}

	}

	public Account save(Account account) throws Exception {

		try {
			account.setId(UUID.randomUUID());
			return repo.save(account);

		} catch (Exception e) {
			log.error(ExceptionConstants.EXCEPTION, e);
			throw new Exception(ExceptionConstants.EXCEPTION_DB_INSERT);

		}
		
	}
	
	public void delete(Account account) throws Exception {

		try {
			
			repo.delete(account);

		} catch (Exception e) {
			log.error(ExceptionConstants.EXCEPTION, e);
			throw new Exception(ExceptionConstants.EXCEPTION_DB_DELETE);

		}
		
	}

}
