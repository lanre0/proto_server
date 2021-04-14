package com.task.betpawa_server.exceptions;

import com.task.betpawa_proto.StatusMessage;
import io.grpc.StatusRuntimeException;
import io.grpc.Status;

public class ErrorException extends StatusRuntimeException {
    private static final long serialVersionUID = 1L;
    
    private StatusMessage errorStatus;
    
    public ErrorException(Status status, StatusMessage errorStatus) {
        super(status); 
        this.errorStatus = errorStatus; 
    }
    
    public StatusMessage getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(StatusMessage errorStatus) {
        this.errorStatus = errorStatus;
    }

}
