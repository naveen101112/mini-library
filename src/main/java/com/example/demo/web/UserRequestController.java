package com.example.demo.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.UserRequest;
import com.example.demo.service.UserRequestService;
import com.example.demo.web.dto.UserRequestDto;

@Controller
@RequestMapping("/raiseRequest")

public class UserRequestController {

	private UserRequestService userRequestService;

	public UserRequestController(UserRequestService userRequestService) {
		super();
		this.userRequestService = userRequestService;
	}
	
	@ModelAttribute("userRequest")
    public UserRequestDto userRequestDto() {
        return new UserRequestDto();
    }
	
	
	public String showRequestList(Model model) {
		model.addAttribute("listRequests", userRequestService.getList());
		return "raiseRequest";
	}
	
	@GetMapping
	public ResponseEntity<List<UserRequest>> listAllUsers() {
        List<UserRequest> users = userRequestService.getList();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserRequest>>(users, HttpStatus.OK);
    }
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("userRequest") UserRequestDto requestDto) {
		userRequestService.save(requestDto);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getName().equals("admin@gmail.com"))
			return "admin";
		return "index";
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable Long id) {
		userRequestService.delete(id);
		return "index";
	}
}
