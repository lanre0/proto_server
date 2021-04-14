package com.task.betpawa_server.service;

import com.task.betpawa_proto.OperationServiceGrpc.OperationServiceImplBase;
import com.task.betpawa_server.entity.Balance;
import com.task.betpawa_server.entity.BalanceId;
import com.task.betpawa_server.entity.Currency;
import com.task.betpawa_server.entity.User;
import com.task.betpawa_server.repository.UserRepository;
import com.task.betpawa_proto.Request;
import com.task.betpawa_proto.Response;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.task.betpawa_proto.OPERATION;
import com.task.betpawa_proto.STATUS;
import com.task.betpawa_proto.OperationServiceGrpc;  


import io.grpc.stub.StreamObserver;
 
 
public class OperationServiceImpl extends OperationServiceImplBase {
	 private final  PointCall pointcall;

	  public OperationServiceImpl(PointCall pointcall) {
	    this.pointcall = pointcall;
	  }
	 
	  
	 @Override
	  public void balance(final Request request, final StreamObserver<Response> responseObserver) {
			try {
	 
	    Long longId= new Long(request.getUserID());
	   
	    String balanceValue = ""; 
	    balanceValue=pointcall.balanceCall(longId, request.getCurrency().toString());
	  
	     Response response =  Response.newBuilder().setStatusMessage(balanceValue)//
	    
	    		 .setStatus(STATUS.TRANSACTION_SUCCESS)
	      .build();
 
	    responseObserver.onNext(response);
 
	    responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace(); 
		 }
	  }
	 
	 @Override
	  public void deposit(final Request request, final StreamObserver<Response> responseObserver) {
	 
	    String result = "";
	    Long longId= new Long(request.getUserID());
	    result=pointcall.depositCall(longId, request.getCurrency().toString(),request.getAmount());
	  
	     Response response =  Response.newBuilder().setStatusMessage(result)//
	   
	      .build();
 
	    responseObserver.onNext(response);
 
	    responseObserver.onCompleted();
	  }
	 
	 @Override
	  public void withdraw(final Request request, final StreamObserver<Response> responseObserver) {
	 
	    String result = "";
	    Long longId= new Long(request.getUserID());
	    result= pointcall.withdrawalCall(longId, request.getCurrency().toString(),request.getAmount());
	  
	     Response response =  Response.newBuilder().setStatusMessage(result)//
	    
	      .build();
 
	    responseObserver.onNext(response);
 
	    responseObserver.onCompleted();
	  }
	 
	 
	 
	 
	 private  String Test() {
		 
		 
			return "OK";
		}
}
