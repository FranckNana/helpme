package com.cf.helpMe.RestControler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cf.helpMe.RestService.SearchRestService;

@RestController
@CrossOrigin
public class SearchController {
	
	@Autowired
	private SearchRestService searchRestService;

	@GetMapping(value = "/search/users/username/{username}")
	public ResponseEntity<?> searchByUserName(@PathVariable String username) throws Exception {
		return ResponseEntity.ok(searchRestService.searchUsersByUserName(username));
	}
	
	@GetMapping(value = "/search/users/course/{matiere}")
	public ResponseEntity<?> searchByCourse(@PathVariable String matiere) throws Exception {
		return ResponseEntity.ok(searchRestService.searchUsersByCourse(matiere));
	}
	
	@GetMapping(value = "/search/users/publications/{matiere}")
	public ResponseEntity<?> searchPubByMatiere(@PathVariable String matiere) throws Exception {
		return ResponseEntity.ok(searchRestService.searchPublicationsByMatiere(matiere));
	}
}
