package com.task.betpawa_server.service;

import com.task.betpawa_server.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserServices {
    public Optional<User> findByUser_id(Long user_id);
}
