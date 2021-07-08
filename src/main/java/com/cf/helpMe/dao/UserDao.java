package com.cf.helpMe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cf.helpMe.model.DAOUser;

@Repository
@Transactional
public interface UserDao extends CrudRepository<DAOUser, String>{
	DAOUser findByUsername(String username);

	void deleteByUsername(String username);

	List<DAOUser> findAll();
}
