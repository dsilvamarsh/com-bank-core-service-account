package com.bank.core.service.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bank.core.service.model.Account;

public interface AccountRepository extends CrudRepository<Account, UUID> {

}
