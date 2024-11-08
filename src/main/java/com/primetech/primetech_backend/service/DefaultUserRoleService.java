package com.primetech.primetech_backend.service;

import com.primetech.primetech_backend.entity.Role;
import com.primetech.primetech_backend.entity.User;
import com.primetech.primetech_backend.entity.UserRole;
import com.primetech.primetech_backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserRoleService implements UserRoleService{

    @Autowired
    private RoleRepository repository;

    @Override
    public void register(User user) {
      repository.insertUserRole(1,1);
    }

    @Override
    public void updateRole(String email) {

    }
}
