package com.task.betpawa_server.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "balance")
public class Balance {


    @EmbeddedId
    private BalanceId balance_id;

    @NotNull
    private BigDecimal balance;
    
    
    
    @ManyToOne
    @JoinColumn(name = "currency_id",insertable = false, updatable = false)
    private Currency currency;
    
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private User user;
    
    
    public BalanceId getBalance_id() {
        return balance_id;
    }

    public void setBalance_id(BalanceId balance_id) {
        this.balance_id = balance_id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	 
    
 
}
