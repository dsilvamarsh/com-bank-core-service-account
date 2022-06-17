package com.bank.core.service.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private UUID id;
	@Version
	private int version;
	private BigDecimal balance;
	private int currency;
}
