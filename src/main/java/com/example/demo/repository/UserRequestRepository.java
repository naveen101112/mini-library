package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRequest;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long>{
	List<UserRequest> findByEmail(@Param("email") String name);
}
