package com.example.demo.web.dto;

import org.springframework.beans.factory.annotation.Value;

public class UserRequestDto {
	private String request_for;
	private Long id;

	private String descr;
	private long dept_id;
	@Value("P")
	private String status;
	private String notes;
	private String email;
	
	public UserRequestDto(){
		
	}

	public UserRequestDto(Long id,String request_for, String descr, long dept_id, String status, String notes, String email) {
		super();
		this.id=id;
		this.request_for = request_for;
		this.descr = descr;
		this.dept_id = dept_id;
		this.status = status;
		this.notes = notes;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		System.out.println("Id is:"+id);
		this.id = id;
	}
	
	public String getRequest_for() {
		return request_for;
	}

	public void setRequest_for(String request_for) {
		this.request_for = request_for;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public long getDept_id() {
		return dept_id;
	}

	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}