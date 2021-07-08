package com.cf.helpMe.jwtControler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cf.helpMe.jwtConfig.JwtTokenUtil;
import com.cf.helpMe.jwtModel.JwtRequest;
import com.cf.helpMe.jwtModel.JwtResponse;
import com.cf.helpMe.jwtService.JwtUserDetailsService;
import com.cf.helpMe.model.DAOUser;
import com.cf.helpMe.model.UserDTO;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	/**
	 * Authentification avec jwt
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	/**
	 * Enregistrement d'un nouvel utilisateur
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	
	/**
	 * supression d'un utilisateur à travers son username
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(value= "users/delete/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username) throws Exception {
		userDetailsService.delete(username);
		if(userDetailsService.findUserByUsername(username)==null) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	/**
	 * Modification du compte utilisateur
	 * Attention ! le service consomme un user avec tous les champs remplis
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user) throws Exception {
		DAOUser userUpdated = userDetailsService.save(user);
		return ResponseEntity.ok(userUpdated);
	}
	
	
	/**
	 * retourn la liste de tous les utilisateurs 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> findAllUsers() throws Exception {
		List<DAOUser> listOfUsers = userDetailsService.findAllUser();
		return ResponseEntity.ok(listOfUsers);
	}
	
	
	/**
	 * retour le user passer en paramètre
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> findAllUsers(@PathVariable String username) throws Exception {
		DAOUser user = userDetailsService.findUserByUsername(username);
		return ResponseEntity.ok(user);
	}
	

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
