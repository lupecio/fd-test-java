package com.bragalucas.fdtest.services;

import java.util.Optional;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bragalucas.fdtest.domain.User;
import com.bragalucas.fdtest.repositories.UserRepository;
import com.bragalucas.fdtest.resources.exception.EmailExistsException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User save(User user) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		
		user.setHashedPassword(encryptedPassword);
		
		Optional<User> userData = this.repository.findByEmail(user.getEmail());
		
		if (!userData.isEmpty()) {
			throw new EmailExistsException();
		}
		
		
		return repository.save(user);
	}

}
