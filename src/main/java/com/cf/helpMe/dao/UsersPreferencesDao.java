package com.cf.helpMe.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cf.helpMe.model.DAOUsersPreference;

@Repository
@Transactional
public interface UsersPreferencesDao extends CrudRepository<DAOUsersPreference, Integer>{

	@Query("SELECT p FROM DAOUsersPreference p WHERE user_id = :user_id")
	DAOUsersPreference findUsersPreferencesByUserId(@Param("user_id") String email);
}
