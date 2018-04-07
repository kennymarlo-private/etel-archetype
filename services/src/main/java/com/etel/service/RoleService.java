package com.etel.service;

import com.etel.model.Role;

public interface RoleService {
    Role findByName(String name);
}
