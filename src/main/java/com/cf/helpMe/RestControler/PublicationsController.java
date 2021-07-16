package com.cf.helpMe.RestControler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cf.helpMe.RestService.PublicationsRestService;
import com.cf.helpMe.model.PublicationsDTO;

@RestController
@CrossOrigin
public class PublicationsController {
	
	@Autowired
	private PublicationsRestService publicationsRestService;

	@RequestMapping(value = "/user/publication", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody PublicationsDTO pub) throws Exception {
		return ResponseEntity.ok(publicationsRestService.addPublications(pub));
	}
}
