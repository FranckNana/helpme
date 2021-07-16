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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="users")
public class DAOUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@Getter
	@Setter
	private String email;
	
	@JsonIgnore
	@Getter
	@Setter
	private String password;
	
	@Column
	@Getter
	@Setter
	private String username;
	
	@Column
	@Getter
	@Setter
	private String country;
	
	@Column
	@Getter
	@Setter
	private String school;
	
	@Column
	@Getter
	@Setter
	private String level;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	@Fetch(value=FetchMode.SELECT)
	private Set<DAOUsersPreference> preferences = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	@Fetch(value=FetchMode.SELECT)
	private Set<DAOPublications> publication = new HashSet<>();
	
	public boolean addPreference(DAOUsersPreference pref) {
		return this.preferences.add(pref);
	}
	
	public boolean addPublications(DAOPublications newPub) {
		return this.publication.add(newPub);
	}
}
