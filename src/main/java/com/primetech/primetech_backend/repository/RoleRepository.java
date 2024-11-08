package com.primetech.primetech_backend.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RoleRepository {

    @Autowired
    private EntityManager entity;

    public void insertUserRole(Integer userId, Integer roleId) {
        String sql = "INSERT INTO users_roles (user_id, role_id) VALUES (:userId, :roleId)";

        Query query = entity.createNativeQuery(sql);

        query.setParameter("userId", userId);
        query.setParameter("roleId", roleId);

        System.out.println(query);

        query.executeUpdate();
    }
}
