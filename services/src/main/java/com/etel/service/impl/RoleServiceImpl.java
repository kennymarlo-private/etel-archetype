package com.etel.service.impl;

import com.etel.model.Role;
import com.etel.repository.RoleRepository;
import com.etel.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
