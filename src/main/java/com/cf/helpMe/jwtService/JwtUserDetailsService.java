package com.cf.helpMe.jwtService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cf.helpMe.dao.UserDao;
import com.cf.helpMe.model.DAOUser;
import com.cf.helpMe.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUsername(user.getUsername());
		newUser.setCountry(user.getCountry());
		newUser.setSchool(user.getSchool());
		newUser.setLevel(user.getLevel());
		
		return userDao.save(newUser);
	}
	
	public void delete(String username) {
		userDao.deleteByUsername(username);
	}
	
	public DAOUser findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public List<DAOUser> findAllUser() {
		return userDao.findAll();
	}
}
