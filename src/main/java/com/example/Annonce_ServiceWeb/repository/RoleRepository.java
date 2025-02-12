package com.example.Annonce_ServiceWeb.repository;

import com.example.Annonce_ServiceWeb.model.Role;
import com.example.Annonce_ServiceWeb.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}