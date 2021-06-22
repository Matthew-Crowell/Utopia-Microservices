package com.smoothstack.utopia.services;

import com.smoothstack.utopia.entities.User;
import com.smoothstack.utopia.entities.UserRole;
import com.smoothstack.utopia.repos.UserRepository;
import com.smoothstack.utopia.repos.UserRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private UserRoleRepository roleRepository;

	@Autowired
	private UserService userService;

	private User user;
	private User userB;
	private UserRole role;
	private List<User> users;

	@BeforeEach
	void setUp() {
		role = new UserRole();
		role.setId(2);
		role.setName("traveler");
		user = new User();
		user.setId(1);
		user.setRole(role);
		user.setUsername("user.one");
		user.setGivenName("User");
		user.setFamilyName("One");
		user.setEmail("user.one@email.com");
		user.setPhone("123-456-7890");
		user.setPassword("encrypt-me");
		users = new ArrayList<>();
		users.add(user);
	}

	@Test
	void addUser() {
		when(userRepository.save(any())).thenReturn(user);
		when(roleRepository.findById(any())).thenReturn(Optional.of(role));
		assertSame(user, userService.addUser(user));
		verify(userRepository).save(any());
		verify(roleRepository).findById(any());
		assertTrue(userService.getUsers().isEmpty());
	}

	@Test
	void getUsers() {
		when(userRepository.findAll()).thenReturn(users);
		assertSame(users, userService.getUsers());
		verify(userRepository).findAll();
	}

	@Test
	void getUserById() {
		when(userRepository.findById(any())).thenReturn(Optional.of(user));
		assertSame(user, userService.getUserById(1));
		verify(userRepository).findById(any());
	}

	@Test
	void getUsersByPartialName() {
		when(userRepository.findUsersByPartialName(any())).thenReturn(users);
		assertSame(users, userService.getUsersByPartialName(any()));
		verify(userRepository).findUsersByPartialName(any());
	}

	@Test
	void getUsersByFullName() {
		when(userRepository.findUsersByFullName(any(), any())).thenReturn(users);
		assertSame(users, userService.getUsersByFullName(any(), any()));
		verify(userRepository).findUsersByFullName(any(), any());
	}

	@Test
	void getUserByEmail() {
		when(userRepository.findUserByEmail(any())).thenReturn(user);
		assertSame(user, userService.getUserByEmail(any()));
		verify(userRepository).findUserByEmail(any());
	}

	@Test
	void getUserByPhone() {
		when(userRepository.findUserByPhone(any())).thenReturn(user);
		assertSame(user, userService.getUserByPhone(any()));
		verify(userRepository).findUserByPhone(any());
	}

	@Test
	void updateUser() {
		User userB = new User();
		userB.setId(2);
		userB.setRole(role);
		userB.setUsername("resu.two");
		userB.setGivenName("Resu");
		userB.setFamilyName("Two");
		userB.setEmail("resu.two@email.com");
		userB.setPhone("987-645-3210");
		userB.setPassword("plain-text");

		when(userRepository.findById(any())).thenReturn(Optional.of(userB));
		when(userRepository.save(any())).thenReturn(userB);
		assertSame(userB, userService.updateUser(user));
		verify(userRepository).save(any());
		assertTrue(userService.getUsers().isEmpty());
	}

	@Test
	void deleteUser() {
		doNothing().when(userRepository).delete(any());
		when(userRepository.findById(any())).thenReturn(Optional.of(user));
		when(roleRepository.findById(any())).thenReturn(Optional.of(role));
		assertSame(user, userService.deleteUser(1));
		verify(userRepository).deleteById(any());
		assertTrue(userService.getUsers().isEmpty());
	}
}