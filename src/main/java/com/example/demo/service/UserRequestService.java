package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserRequest;
import com.example.demo.web.dto.UserRequestDto;

public interface UserRequestService{
	UserRequest save(UserRequestDto requestDto);
	List<UserRequest> getList();
	void delete(Long id);
}
