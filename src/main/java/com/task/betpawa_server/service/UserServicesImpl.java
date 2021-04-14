package com.task.betpawa_server.service;

import com.task.betpawa_server.entity.User;
import com.task.betpawa_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> findByUser_id(Long user_id) {
        return userRepository.findById(user_id);
    }
}
