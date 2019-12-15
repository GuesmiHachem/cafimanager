package com.cafimanager.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cafimanager.model.Role;
import com.cafimanager.model.User;
import com.cafimanager.repository.RoleRepository;
import com.cafimanager.repository.UserRepository;
import com.cafimanager.service.UserService;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	public UserRepository userRepository;


	@Override
	public void create(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		userRepository.save(user);
	}

	@Override
	public void create(User user, Role role) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		user.setRole(role);
		userRepository.save(user);
	}
	
	@Override
	public void addRoleToUser(User user) {
		// TODO Auto-generated method stub
		//Role role 
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return userRepository.count();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<User> findAll(int page, int size, Sort sort) {
		// TODO Auto-generated method stub
		return userRepository.findAll(new PageRequest(page, size, sort));
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByRole(Role role) {
		// TODO Auto-generated method stub
		return userRepository.findByRole(role);
	}

	

}
