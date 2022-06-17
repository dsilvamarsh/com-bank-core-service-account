package com.bank.core.service.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.core.service.constants.SuccessConstants;
import com.bank.core.service.model.Account;
import com.bank.core.service.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@AllArgsConstructor
public class AccountController {

	private AccountService service;

	@GetMapping("/account/{id}")
	
	public ResponseEntity<Account> find(@PathVariable(name = "id") UUID id) throws Exception {

		Optional<Account> tmp = service.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(tmp.get());

	}

	@PostMapping("/account")
	public ResponseEntity<Account> save(@RequestBody(required = true) Account account) throws Exception {

		Account tmp = service.save(account);
		return ResponseEntity.status(HttpStatus.OK).body(tmp);
	}

	@DeleteMapping("/account")
	public ResponseEntity<String> delete(@RequestBody(required = true) Account account) throws Exception {

		service.delete(account);
		return ResponseEntity.status(HttpStatus.OK).body(SuccessConstants.RECORD_DELETED);

	}
}
