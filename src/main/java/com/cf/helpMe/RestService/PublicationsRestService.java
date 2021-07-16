package com.cf.helpMe.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.helpMe.Type.MatiereType;
import com.cf.helpMe.dao.PreferenceDao;
import com.cf.helpMe.dao.PublicationsDAO;
import com.cf.helpMe.dao.UserDao;
import com.cf.helpMe.model.DAOPublications;
import com.cf.helpMe.model.DAOUser;
import com.cf.helpMe.model.PublicationsDTO;

@Service
public class PublicationsRestService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PreferenceDao preferenceDao;
	
	@Autowired
	PublicationsDAO publicationsDAO;
	
	public DAOPublications addPublications(PublicationsDTO pub) {
		DAOUser user = userDao.findByUsername(pub.getUsername());
		
		DAOPublications newPub = new DAOPublications();
		
		newPub.setUser(user);
		newPub.setLink(pub.getLink());
		newPub.setMatiere(MatiereType.of(preferenceDao.findByMatiere(pub.getMatiere()).getMatiere()));
		
		return publicationsDAO.save(newPub);
	}
}
