package com.task.betpawa_server.repository;

import java.util.List;
import java.util.Optional;

import com.task.betpawa_server.dto.BalanceDto;
import com.task.betpawa_server.entity.Balance;
import com.task.betpawa_server.entity.BalanceId;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface BalanceRepository extends JpaRepository <Balance, BalanceId>{ 
	
	
	  @Query("SELECT b FROM Balance as b  WHERE b.balance_id.user_id = :userId")
	   List<Balance> findByUser_id(@Param("userId") Long paramLong);
	  
	  
	  @Query("SELECT b FROM Balance as b  WHERE b.balance_id.user_id = :userId")
	  Optional<List<Balance>> findByUserId(@Param("userId") Long paramLong);
	  
	   
}
