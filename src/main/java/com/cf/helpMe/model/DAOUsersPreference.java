package com.cf.helpMe.model;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name ="users_preferences")
@Data
public class DAOUsersPreference implements Serializable{
	
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
    
    @Column
    @Enumerated(EnumType.STRING)
    MatiereType choix1;
    
    @Column
    @Enumerated(EnumType.STRING)
    MatiereType choix2;
    
    @Column
    @Enumerated(EnumType.STRING)
    MatiereType choix3;
}
