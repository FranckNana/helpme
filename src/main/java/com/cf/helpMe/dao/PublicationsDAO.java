package com.cf.helpMe.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cf.helpMe.model.DAOPublications;

@Repository
@Transactional
public interface PublicationsDAO extends CrudRepository<DAOPublications, String>{

}
