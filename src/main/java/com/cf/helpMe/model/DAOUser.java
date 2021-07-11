package com.cf.helpMe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	@Fetch(value=FetchMode.SELECT)
	private Set<DAOUsersPreference> preferences = new HashSet<>();
	
	public boolean addPreference(DAOUsersPreference pref) {
		return this.preferences.add(pref);
	}
}
