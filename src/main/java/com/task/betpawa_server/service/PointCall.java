package com.task.betpawa_server.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.betpawa_server.dto.BalanceDto;
import com.task.betpawa_server.dto.BalanceResponce;
import com.task.betpawa_server.entity.Balance;
import com.task.betpawa_server.entity.BalanceId;
import com.task.betpawa_server.entity.Currency;
import com.task.betpawa_server.entity.User;
import com.task.betpawa_server.exceptions.ValidationException;
import com.task.betpawa_server.validation.Validate;
import com.task.betpawa_proto.StatusMessage;
import com.task.betpawa_proto.STATUS;
import com.google.gson.Gson;

@Service
public class PointCall {

	
	@Autowired
	UserServices userServices;
	@Autowired
	CurrencyServices currencyServices;
	@Autowired
	BalanceServices balanceServices;
	@Autowired
	Validate validate;
	@Autowired
	BalanceResponce balanceResponce;
	 
	
	public String balanceCall(Long userId,String currencies) {
		 
		String balanceValue=""; 
	    StringBuilder sb = new StringBuilder(110);
		Optional<List<Balance>> bal = balanceServices.findByUserIds2(userId);
		 if(bal.isPresent()){  
			List<Balance> balanc =bal.get();
			
			 sb.append("");
			 for(int i=0;i<balanc.size();i++) {
				 Balance balance = balanc.get(i);
			     String newval= balance.getCurrency().getCurrencyName() +":"+balance.getBalance();
				 
				 sb.append(newval);
				 sb.append(","); 
			 }   
			 balanceValue=sb.toString();
			 if(balanceValue.endsWith(","))
			 {
				 balanceValue = balanceValue.substring(0,balanceValue.length() - 1);
			 }
		}
		else balanceValue=StatusMessage.USER_DOES_NOT_EXIST.toString();
					  
		return balanceValue;
	}
	
	
public String depositCall(Long userId,String currencies,String addBalance) {
		
		String statusValue="";
	    User user =new User();
		Currency currency =new Currency();
		BalanceId BalanceId=new BalanceId();
		try {
	 	 Optional<User> byUser_id = userServices.findByUser_id(userId);
	 	if(byUser_id.isPresent()){
		 	  user = byUser_id.get();
		 	BalanceId.setUser_id(user.getUser_id()); 
		 }
	 	else statusValue=StatusMessage.USER_DOES_NOT_EXIST.toString();
	 
		Optional<Currency> byCurrency_id = currencyServices.findByCurrency_name(currencies);
		if(byCurrency_id.isPresent()){
			 currency = byCurrency_id.get();
			BalanceId.setCurrencyId(currency.getCurrencyId()); 
		}
		else statusValue=StatusMessage.INVALID_CURRENCY.toString();

	 	Optional<Balance> byBalance_id = balanceServices.findByBalance_id(BalanceId);
		 if(byBalance_id.isPresent()){
		 	final BigDecimal balanceToADD = new BigDecimal(addBalance); 
		 	validate.amountMustGreaterThanZero(balanceToADD);
		 	 balanceServices.updateBalance(balanceToADD, byBalance_id); 
		 	statusValue=STATUS.TRANSACTION_SUCCESS.toString();
		 }
		} catch (ValidationException e) {
			 
			statusValue=e.getErrorStatus().toString();
		} catch (Exception ex) {
			ex.getMessage();
		} finally {

		}
		 
		return statusValue;
	}
	

public String withdrawalCall(Long userId,String currencies,String subtractBalance) {
	
	String statusValue="";
    User user =new User();
	Currency currency =new Currency();
	BalanceId BalanceId=new BalanceId();
	try {
 	 Optional<User> byUser_id = userServices.findByUser_id(userId);
 	if(byUser_id.isPresent()){
	 	  user = byUser_id.get();
	 	BalanceId.setUser_id(user.getUser_id()); 
	 }else statusValue=StatusMessage.USER_DOES_NOT_EXIST.toString();
 
 
	Optional<Currency> byCurrency_id = currencyServices.findByCurrency_name(currencies);
	if(byCurrency_id.isPresent()){
		 currency = byCurrency_id.get();
		BalanceId.setCurrencyId(currency.getCurrencyId()); 
	}else statusValue=StatusMessage.INVALID_CURRENCY.toString();
	 

	Optional<Balance> byBalance_id = balanceServices.findByBalance_id(BalanceId);
	if(byBalance_id.isPresent()){ 
		validate.checkAmountLessThanBalance( byBalance_id.get().getBalance(), new BigDecimal(subtractBalance));
		 final BigDecimal balanceToSUBTRACT = new BigDecimal(subtractBalance);
		  balanceServices.subtractBalance(balanceToSUBTRACT, byBalance_id);
		  statusValue=STATUS.TRANSACTION_SUCCESS.toString();
	}
	
	} catch (ValidationException e) { 
		 statusValue=e.getErrorStatus().toString(); 
	} catch (Exception ex) {
		ex.getMessage();
	} finally {

	}
	return statusValue;
}


private BalanceId getBalanceId(Long userId,String currencies)
   {
	        String balanceValue="";
	        User user =new User();
			Currency currency =new Currency();
			BalanceId balanceId=new BalanceId();
		 
		 	 Optional<User> byUser_id = userServices.findByUser_id(userId);
		 	if(byUser_id.isPresent()){
			 	  user = byUser_id.get();
			 	 balanceId.setUser_id(user.getUser_id()); 
			 }else balanceValue=StatusMessage.USER_DOES_NOT_EXIST.toString();
		 
		 
			Optional<Currency> byCurrency_id = currencyServices.findByCurrency_name(currencies);
			if(byCurrency_id.isPresent()){
				 currency = byCurrency_id.get();
				 balanceId.setCurrencyId(currency.getCurrencyId()); 
			}else balanceValue=StatusMessage.INVALID_CURRENCY.toString();
			
			Optional<Balance> byBalance_id = balanceServices.findByBalance_id(balanceId);
			if(byBalance_id.isPresent()){
			//	final BigDecimal balanceToADD = new BigDecimal(4300);
				Balance balance = byBalance_id.get();
				balanceValue=balance.getBalance().toString();
			}
		 
			System.out.println(balanceServices.findByUserIds(user.getUser_id()).size());
	 
			
			return balanceId;
	}


 
}
