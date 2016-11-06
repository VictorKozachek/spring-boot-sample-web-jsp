package ru.schoolarlife.logic.model.dao;

import ru.schoolarlife.logic.bo.security.User;

import java.util.List;

/**
 * Created by victor on 06.11.16.
 */
public interface UserDao {
    public void save(User user);

    public void delete(User user);

    public List getAll();

    public User getByEmail(String email);

    public User getById(long id);

    public void update(User user);
}
