package ru.vsu.csf.alcomanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.csf.alcomanager.model.Role;
import ru.vsu.csf.alcomanager.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository userRoleRepository) {
        this.roleRepository = userRoleRepository;
    }

    public void add(Role value) {
        this.roleRepository.save(value);
    }
}
