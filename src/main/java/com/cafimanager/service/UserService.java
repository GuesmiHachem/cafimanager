package com.cafimanager.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import com.cafimanager.model.Role;
import com.cafimanager.model.User;

public interface UserService {
	
	public void create(User user);
	public void create(User user,Role role);
	public void addRoleToUser(User user);
	public void deleteById(Long id);
	public void update(User user);
	public User findById(long id);
	public User findByEmail(String email);
	public List<User> findByRole(Role role);
	public List<User> findAll();
	public Page<User> findAll(int page,int size,Sort sort);
	public long size();
	
	
}
