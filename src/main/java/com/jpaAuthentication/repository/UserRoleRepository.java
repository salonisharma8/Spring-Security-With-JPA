package com.jpaAuthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpaAuthentication.entity.User;
import com.jpaAuthentication.entity.UserRole;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
	UserRole findByuser(User user);
}
