package com.cafimanager.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cafimanager.model.Role;
import com.cafimanager.repository.RoleRepository;
import com.cafimanager.service.RoleService;

@Service("roleServiceImpl")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void create(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public Role findById(long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	@Override
	public Role findByRole(String role) {
		// TODO Auto-generated method stub
		return roleRepository.findByRole(role);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<Role> findAll(int page, int size, Sort sort) {
		// TODO Auto-generated method stub
		return roleRepository.findAll(new PageRequest(page, size, sort));
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return roleRepository.count();
	}
	

}
