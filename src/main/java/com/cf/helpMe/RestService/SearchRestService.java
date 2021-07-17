package com.cf.helpMe.RestService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.helpMe.Type.MatiereType;
import com.cf.helpMe.dao.PublicationsDAO;
import com.cf.helpMe.dao.UserDao;
import com.cf.helpMe.dao.UsersPreferencesDao;
import com.cf.helpMe.model.DAOPublications;
import com.cf.helpMe.model.DAOUser;
import com.cf.helpMe.model.DAOUsersPreference;

@Service
public class SearchRestService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UsersPreferencesDao usersPreferencesDao;
	
	@Autowired
	PublicationsDAO publicationsDAO;

	public List<DAOUser> searchUsersByUserName(String username) {
		List<DAOUser> allUsers = userDao.findAll();
		List<DAOUser> listOfUsers = new ArrayList<>();
		
		for(int i=0;i<allUsers.size();i++) {
			if(allUsers.get(i).getUsername().contains(username)) {
				listOfUsers.add(allUsers.get(i));
			}
		}
		allUsers.clear();
		return listOfUsers;
	}
	
	public List<DAOUser> searchUsersByCourse(String matiere) {
		List<DAOUsersPreference> userPref = usersPreferencesDao.findUsersPreferenceByPreference(MatiereType.of(matiere));
		List<DAOUser> listOfUsers = new ArrayList<>();
		
		for(int i=0;i<userPref.size();i++) {
			listOfUsers.add(userPref.get(i).getUser());
		}
		userPref.clear();
		return listOfUsers;
	}
	
	public List<DAOPublications> searchPublicationsByMatiere(String matiere) {
		return publicationsDAO.findPubByMatiere(MatiereType.of(matiere));
	}
	
	
}
