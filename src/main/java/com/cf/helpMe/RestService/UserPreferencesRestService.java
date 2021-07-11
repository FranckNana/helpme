package com.cf.helpMe.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.helpMe.Type.MatiereType;
import com.cf.helpMe.dao.PreferenceDao;
import com.cf.helpMe.dao.UserDao;
import com.cf.helpMe.dao.UsersPreferencesDao;
import com.cf.helpMe.model.DAOUser;
import com.cf.helpMe.model.DAOUsersPreference;
import com.cf.helpMe.model.UserPreferencesDTO;

@Service
public class UserPreferencesRestService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PreferenceDao preferenceDao;
	
	@Autowired
	UsersPreferencesDao usersPreferencesDao;
	
	public DAOUsersPreference addPreference(UserPreferencesDTO userPref) {
		DAOUser user = userDao.findByUsername(userPref.getUsername());
		
		DAOUsersPreference pref = new DAOUsersPreference();
		
		pref.setUser(user);
		pref.setChoix1(MatiereType.of(preferenceDao.findByMatiere(userPref.getChoix1()).getMatiere()));
		pref.setChoix2(MatiereType.of(preferenceDao.findByMatiere(userPref.getChoix2()).getMatiere()));
		pref.setChoix3(MatiereType.of(preferenceDao.findByMatiere(userPref.getChoix3()).getMatiere()));
		
		return usersPreferencesDao.save(pref);
	}
}
