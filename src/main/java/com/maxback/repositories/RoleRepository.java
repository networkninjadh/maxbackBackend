package com.maxback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxback.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}