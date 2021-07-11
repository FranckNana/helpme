package com.cf.helpMe.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cf.helpMe.model.DAOUsersPreference;

@Repository
@Transactional
public interface UsersPreferencesDao extends CrudRepository<DAOUsersPreference, Integer>{

}
