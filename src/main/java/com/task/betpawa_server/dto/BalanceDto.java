package com.task.betpawa_server.dto;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.task.betpawa_server.entity.BalanceId;

public class BalanceDto {

	
	 private Long user_id;
	 
	 private Long currencyId;
	 
	 private String currencyName;
	 
	 private BigDecimal balance;

	public BalanceDto(Long user_id, Long currencyId, String currencyName, BigDecimal balance) {
		super();
		this.user_id = user_id;
		this.currencyId = currencyId;
		this.currencyName = currencyName;
		this.balance = balance;
	}
	 
	  @ManyToOne
	    @JoinColumns({
	        @JoinColumn(
	            name = "currency_id",
	            referencedColumnName = "currency_id"),
	        @JoinColumn(
	            name = "user_id",
	            referencedColumnName = "user_id")
	    })
	    private BalanceId balanceId;
	  
	public BalanceDto() { 
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public Long getCurrencyId() {
		return currencyId;
	}


	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}


	public String getCurrencyName() {
		return currencyName;
	}


	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public BalanceId getBalanceId() {
		return balanceId;
	}


	public void setBalanceId(BalanceId balanceId) {
		this.balanceId = balanceId;
	}
	 
	
	
}
