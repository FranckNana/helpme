package com.cf.helpMe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cf.helpMe.Type.MatiereType;

import lombok.Data;

@Entity
@Table(name ="publications")
@Data
public class DAOPublications implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
	private int id;
	
    @ManyToOne
    @JoinColumn(name="user_id")
    private DAOUser user;

	private String link;
	
    @Enumerated(EnumType.STRING)
	private MatiereType matiere;
}
