package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
    
}