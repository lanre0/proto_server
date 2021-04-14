package com.task.betpawa_server;

import com.task.betpawa_server.config.EnvironmentProperties;
import com.task.betpawa_server.entity.Balance;
import com.task.betpawa_server.entity.BalanceId;
import com.task.betpawa_server.entity.Currency;
import com.task.betpawa_server.entity.User;
import com.task.betpawa_server.repository.UserRepository;
import com.task.betpawa_server.service.BalanceServices;
import com.task.betpawa_server.service.CurrencyServices;
import com.task.betpawa_server.service.OperationServiceImpl;
import com.task.betpawa_server.service.PointCall;
import com.task.betpawa_server.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Optional;

import io.grpc.*;

@SpringBootApplication
public class BetpawaServerApplication {

	@Autowired
	UserServices userServices;
	@Autowired
	CurrencyServices currencyServices;
	@Autowired
	BalanceServices balanceServices;
	@Autowired
	private EnvironmentProperties environmentProperties;
	@Autowired
	PointCall pointcall;

	private static final Logger log = LoggerFactory.getLogger(BetpawaServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BetpawaServerApplication.class, args);
	}


	@Bean
	public CommandLineRunner buildData() {
	
		return (args) -> {
			
		 
			     String port = environmentProperties.getPort();
			     System.out.println("Server grpc on started port "+port);
		    	 Server server = ServerBuilder.forPort(Integer.parseInt(port))
		        .addService(new OperationServiceImpl(pointcall))
		        .build();
 
		      server.start(); 
 
		      System.out.println("Server started"); 
		      
		      server.awaitTermination();
			
			
			
		};
	}
	
	 
}
