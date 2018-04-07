package com.etel.service.impl;

import com.etel.model.User;
import com.etel.repository.UserRepository;
import com.etel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveOrUpdate(User user) {
        User mUser = userRepository.findOne(user.getId());
        if(mUser == null){
            logger.info("Saved new user");
            userRepository.save(user);
        }else{
            mUser.setAccountExpired(user.isAccountExpired());
            mUser.setAccountLocked(user.isAccountLocked());
            mUser.setCredentialsExpired(user.isCredentialsExpired());
            mUser.setEnabled(user.isEnabled());
            mUser.setPassword(user.getPassword());
            mUser.setEmail(user.getEmail());
            mUser.setRoles(user.getRoles());
            userRepository.save(mUser);
            logger.info("Updated user: username {}", mUser.getUsername());
        }
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findOne(id);
        user.setCredentialsExpired(true);
        userRepository.save(user);
        logger.info("Disabled user {}", user.getUsername());
    }

    @Override
    public User findByUsername(String username) {
        logger.info("Find user with username {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsernameAndEmail(String username, String email) {
        logger.info("Find user with username {} and email {}", username, email);
        return userRepository.findByUsernameAndEmail(username, email);
    }

    @Override
    public List<User> findByEnabled(boolean enabled) {
        logger.info("Find all enabled users");
        return userRepository.findByEnabled(true);
    }
}
