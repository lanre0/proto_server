package com.task.betpawa_server.exceptions;

import com.task.betpawa_proto.StatusMessage;

import io.grpc.Status;

public class ValidationException extends ErrorException{
	private static final long serialVersionUID =  1L;
	
	public ValidationException(Status status, StatusMessage errorStatus) {
		
		super(status, errorStatus);
		// TODO Auto-generated constructor stub
	}

	
}
