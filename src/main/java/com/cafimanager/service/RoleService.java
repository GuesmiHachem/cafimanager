package com.cafimanager.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import com.cafimanager.model.Role;

public interface RoleService {
	
	public void create(Role role);
	public void deleteById(Long id);
	public void update(Role role);
	public Role findById(long id);
	public Role findByRole(String role);
	public List<Role> findAll();
	public Page<Role> findAll(int page,int size,Sort sort);
	public long size();
	
	
}
