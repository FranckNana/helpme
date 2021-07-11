package com.cf.helpMe.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cf.helpMe.model.DAOPreferences;

@Repository
@Transactional
public interface PreferenceDao extends CrudRepository<DAOPreferences, String>{

	DAOPreferences findByMatiere(String choix1);
	
}
