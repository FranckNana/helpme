package com.cf.helpMe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cf.helpMe.Type.MatiereType;
import com.cf.helpMe.model.DAOPublications;

@Repository
@Transactional
public interface PublicationsDAO extends CrudRepository<DAOPublications, String>{

	@Query("SELECT p FROM DAOPublications p WHERE p.matiere = :matiere")
	List<DAOPublications> findPubByMatiere(@Param("matiere")MatiereType matiere);

}
