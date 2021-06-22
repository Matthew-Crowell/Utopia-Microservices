package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.User;
import com.smoothstack.utopia.entities.UserRole;
import com.smoothstack.utopia.repos.UserRepository;
import com.smoothstack.utopia.repos.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository roleRepository;

	@Override
	@Transactional
	public User addUser(User user) {
		UserRole userRole = roleRepository.findById(user.getRole().getId()).orElse(null);
		user.setRole(userRole);
		user = userRepository.save(user);
		return user;
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User getUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<User> getUsersByPartialName(String partialName) {
		return userRepository.findUsersByPartialName(partialName);
	}

	@Override
	@Transactional
	public List<User> getUsersByFullName(String givenName, String familyName) {
		return userRepository.findUsersByFullName(givenName, familyName);
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	@Transactional
	public User getUserByPhone(String phone) {
		return userRepository.findUserByPhone(phone);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		int roleCount = roleRepository.findRoleCount();

		Optional<User> matchingUser = userRepository.findById(user.getId());
		if (matchingUser.isPresent()) {
			if (user.getUsername().length() > 0) {
				matchingUser.get().setUsername(user.getUsername());
			}

			if (user.getGivenName().length() > 0) {
				matchingUser.get().setGivenName(user.getGivenName());
			}

			if (user.getFamilyName().length() > 0) {
				matchingUser.get().setFamilyName(user.getFamilyName());
			}

			if (user.getRole().getId() > 0 && user.getRole().getId() <= roleCount) {
				matchingUser.get().setRole(user.getRole());
			}

			if (user.getEmail().length() > 0) {
				matchingUser.get().setEmail(user.getEmail());
			}

			if (user.getPhone().length() > 0) {
				matchingUser.get().setPhone(user.getPhone());
			}

			if (user.getPassword().length() > 0) {
				matchingUser.get().setPhone(user.getPhone());
			}

			user = userRepository.save(matchingUser.get());
		}
		return user;
	}

	@Override
	@Transactional
	public User deleteUser(long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()){
			userRepository.deleteById(id);
		}
		return user.orElse(null);
	}
}
