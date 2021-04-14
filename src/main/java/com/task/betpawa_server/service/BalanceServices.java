package com.task.betpawa_server.service;

import com.task.betpawa_server.dto.BalanceDto;
import com.task.betpawa_server.entity.Balance;
import com.task.betpawa_server.entity.BalanceId;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public interface BalanceServices {
	
	 public Optional<Balance> findByBalance_id(BalanceId balance_id);

	    public void updateBalance(final BigDecimal newBalance, final Optional<Balance> balance);

	    public void subtractBalance(final BigDecimal newBalance, final Optional<Balance> balance);
	    
	    public List<Balance> findByUserIds(Long userId);
	    
	    public Optional<List<Balance>> findByUserIds2(Long userID);
	    
	     
    
}
