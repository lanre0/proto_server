package com.task.betpawa_server.service;

import com.task.betpawa_server.dto.BalanceDto;
import com.task.betpawa_server.entity.Balance;
import com.task.betpawa_server.entity.BalanceId;
import com.task.betpawa_server.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import com.google.gson.Gson;
import java.util.List;

@Service
public class BalanceServicesImpl implements  BalanceServices{

	  @Autowired
	    BalanceRepository balanceRepository;
	    @Override
	    public Optional<Balance> findByBalance_id(BalanceId balance_id) {
	        return balanceRepository.findById(balance_id);
	    }

	    @Override
	    public void updateBalance(BigDecimal balanceToADD, Optional<Balance> balance) {
	        balance.get().setBalance(balance.get().getBalance().add(balanceToADD));
	        balanceRepository.saveAndFlush(balance.get());
	    }

	    @Override
	    public void subtractBalance(BigDecimal balanceToSUBTRACT, Optional<Balance> balance) {

	        balance.get().setBalance(balance.get().getBalance().subtract(balanceToSUBTRACT));
	        balanceRepository.saveAndFlush(balance.get());
	    }
	    
	    
	    @Override
	    public List<Balance> findByUserIds(Long userId) {

	        return balanceRepository.findByUser_id(userId);
	    }

		@Override
		public Optional<List<Balance>> findByUserIds2(Long userID) {
			// TODO Auto-generated method stub
			return balanceRepository.findByUserId(userID);
		}

	 
	   
}
