package ru.schoolarlife.logic.bl.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.schoolarlife.logic.bl.security.interfaces.UserService;
import ru.schoolarlife.logic.bo.security.User;
import ru.schoolarlife.logic.model.dao.UserDao;

import java.util.HashSet;

/**
 * Created by victor on 01.11.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {

        return userRepository.getByEmail(email);
    }
}
