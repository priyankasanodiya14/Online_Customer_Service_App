package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Login;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Integer>{
    public Optional<Login> findByUsername(String username);
}
