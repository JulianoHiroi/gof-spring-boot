package com.gof.service;

import org.springframework.stereotype.Service;

import com.gof.model.User;

@Service
public interface UserService {

    public User saveUser(User user);

    public User getUser(Long id);

    public Iterable<User> listUsers();

    public void deleteUser(Long id);

    public User updateUser(User user, Long id);
}
