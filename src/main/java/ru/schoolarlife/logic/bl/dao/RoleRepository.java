package ru.schoolarlife.logic.bl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.schoolarlife.logic.bo.security.Role;

/**
 * Created by victor on 01.11.16.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}