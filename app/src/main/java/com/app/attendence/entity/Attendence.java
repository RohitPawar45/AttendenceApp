package com.app.attendence.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="attendence")
public class Attendence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	private Date signIn;
	
	private Date signOut;
	
	@JsonBackReference
	@ManyToOne()
    @JoinColumn(name = "userId")
	private User user;
	
	public Attendence() {}

	public Attendence(int id, Date date, Date signIn, Date signOut, User user) {
		super();
		this.id = id;
		this.date = date;
		this.signIn = signIn;
		this.signOut = signOut;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getSignIn() {
		return signIn;
	}

	public void setSignIn(Date signIn) {
		this.signIn = signIn;
	}

	public Date getSignOut() {
		return signOut;
	}

	public void setSignOut(Date signOut) {
		this.signOut = signOut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
