package com.etel.service;

import com.etel.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    void saveOrUpdate(User user);
    void delete(Long id);
    User findByUsername(String username);
    User findByUsernameAndEmail(String username, String email);
    List<User> findByEnabled(boolean enabled);
}
