package com.cf.helpMe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name ="users")
@Data
public class DAOUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String email;
	
	@JsonIgnore
	private String password;
	
	@Column
	private String username;
	
	@Column
	private String country;
	
	@Column
	private String school;
	
	@Column
	private String level;
}
