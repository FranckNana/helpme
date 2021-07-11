package com.cf.helpMe.RestControler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cf.helpMe.RestService.UserPreferencesRestService;
import com.cf.helpMe.model.UserPreferencesDTO;

@RestController
@CrossOrigin
public class UserPreferenceControler {
	
	@Autowired
	private UserPreferencesRestService userPreferencesRestService;

	@RequestMapping(value = "/user/preferences", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserPreferencesDTO pref) throws Exception {
		return ResponseEntity.ok(userPreferencesRestService.addPreference(pref));
	}
}
