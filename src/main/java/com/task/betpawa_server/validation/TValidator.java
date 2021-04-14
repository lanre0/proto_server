package com.task.betpawa_server.validation;


import java.util.Objects;
import com.task.betpawa_proto.StatusMessage;
import com.task.betpawa_server.exceptions.ValidationException;

import io.grpc.Status;
public interface TValidator<T> {

    default void validate(T t, String params) {
        if (Objects.isNull(t)) {
            throw new ValidationException(Status.FAILED_PRECONDITION, StatusMessage.INVALID_INPUTS);
        }
    }
}
