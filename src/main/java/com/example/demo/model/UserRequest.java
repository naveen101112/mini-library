package com.example.demo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "REQUEST_TABLE")
public class UserRequest {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@Column(name = "request_for")
	private String request_for;
	
	@Column(name = "descr")
	private String descr;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "dept_id")
	private Long dept_id;
	
	@Column(name = "email")
	private String email;
	
	private String statusDesc;

	public UserRequest() {
		
	}
	
	public UserRequest(Long id,String request_for, String descr, Long dept_id, String status, String notes, String email) {
		super();
		this.id=id;
		this.request_for = request_for;
		this.descr = descr;
		this.status = status;
		this.notes = notes;
		this.dept_id = dept_id;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes==null?"":notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatusDesc() {
		String status=getStatus();
		if(status==null||status.equals("P")){
			return 	"Pending";
		}else if(status.equals("A"))
			return "Accepted";
		else
			return "Rejected";
	}
	
}
