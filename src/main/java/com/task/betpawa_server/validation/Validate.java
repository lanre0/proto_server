package com.task.betpawa_server.validation;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.task.betpawa_proto.StatusMessage;
import com.task.betpawa_server.exceptions.ValidationException;

import io.grpc.Status;

@Component
public class Validate implements TValidator<BigDecimal> {

	
	 public void amountMustGreaterThanZero(final BigDecimal amount) {
	        if (amount.compareTo(BigDecimal.ZERO) < 1) {
	            throw new ValidationException(Status.FAILED_PRECONDITION,   StatusMessage.AMOUNT_MUST_BE_GREATER_THAN_ZERO);
	        }
	    }
	 
	 public void checkAmountLessThanBalance(final BigDecimal balance, final BigDecimal WithdrawAmount) { 
	        if (balance.compareTo(WithdrawAmount) < 0) { 
	            throw new ValidationException(Status.FAILED_PRECONDITION, StatusMessage.INSUFFICIENT_BALANCE);
	        }
}
}