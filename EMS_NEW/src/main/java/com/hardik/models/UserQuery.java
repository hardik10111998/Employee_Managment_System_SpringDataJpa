package com.hardik.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_query")
public class UserQuery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int queryId;
	
	@NotBlank(message="Query Subject is compulsory")
	private String querySubject;
	
	@NotBlank(message="Query Description is compulsory")
	private String comments;
	
	private Date raisedOn;
	
	private boolean status;		//0-> raised || 1->responded By Admin 
	
	@OneToOne
	private Employee employee;
	
	private String reply;

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQuerySubject() {
		return querySubject;
	}

	public void setQuerySubject(String querySubject) {
		this.querySubject = querySubject;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getRaisedOn() {
		return raisedOn;
	}

	public void setRaisedOn(Date raisedOn) {
		this.raisedOn = raisedOn;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "UserQuery [queryId=" + queryId + ", querySubject=" + querySubject + ", comments=" + comments
				+ ", raisedOn=" + raisedOn + ", status=" + status + ", employee=" + employee + ", reply=" + reply + "]";
	}

	

}
