package ru.schoolarlife.logic.bl.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.schoolarlife.logic.bl.security.interfaces.RoleService;
import ru.schoolarlife.logic.bo.security.Role;
import ru.schoolarlife.logic.model.dao.repositories.security.RoleRepository;

/**
 * Created by victor on 07.11.16.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
