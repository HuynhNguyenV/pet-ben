package com.softech.petben.services.springdatajpa;

import com.softech.petben.domain.Role;
import com.softech.petben.repositories.RoleRepository;
import com.softech.petben.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleSDJpaService implements RoleService {

    private final RoleRepository roleRepository;

    public RoleSDJpaService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findAll() {
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role findById(Integer integer) {
        return roleRepository.findById(integer).orElse(null);
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public void delete(Role object) {
        roleRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        roleRepository.deleteById(integer);
    }
}
