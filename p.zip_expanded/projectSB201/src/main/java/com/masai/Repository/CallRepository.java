package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Call;

public interface CallRepository extends JpaRepository<Call, Integer>{

}
