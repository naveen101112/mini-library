package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.demo.model.UserRequest;
import com.example.demo.repository.UserRequestRepository;
import com.example.demo.web.dto.UserRequestDto;

@Service
public class UserRequestServiceImpl implements UserRequestService{

	private UserRequestRepository userRequestRepository;
	
	public UserRequestServiceImpl(UserRequestRepository userRequestRepository) {
		super();
		this.userRequestRepository = userRequestRepository;
	}

	@Override
	public UserRequest save(UserRequestDto requestDto) {
		if(requestDto.getEmail()==null||requestDto.getEmail().equals("")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			requestDto.setEmail(auth.getName());
		}
		if(requestDto.getStatus()==null||requestDto.getStatus().equals("")) {
			requestDto.setStatus("P");
		}
		UserRequest request = new UserRequest(requestDto.getId(),requestDto.getRequest_for(),requestDto.getDescr(),requestDto.getDept_id(),requestDto.getStatus(),requestDto.getNotes(),requestDto.getEmail());
		 return userRequestRepository.save(request);
	}
	
	@Override
	public List<UserRequest> getList() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getName().equals("admin@gmail.com"))
			return userRequestRepository.findAll();
		return userRequestRepository.findByEmail(auth.getName());
	}

	@Override
	public void delete(Long id) {
		userRequestRepository.deleteById(id);
	}
	
}
