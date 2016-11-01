package ru.schoolarlife.logic.bl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.schoolarlife.logic.bo.security.User;

/**
 * Created by victor on 01.11.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}