package com.spring.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
