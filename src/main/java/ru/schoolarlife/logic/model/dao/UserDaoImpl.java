package ru.schoolarlife.logic.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.schoolarlife.logic.bo.security.User;


/**
 * Created by victor on 06.11.16.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        getSession().save(user);
    }

    @Override
    public void delete(User user) {
        getSession().delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return getSession().createQuery("from User").list();
    }

    @Override
    public User getByEmail(String email) {
        return (User) getSession().createQuery(
                "from User where email = :email")
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public User getById(long id) {
        return (User) getSession().load(User.class, id);
    }

    @Override
    public void update(User user) {
        getSession().update(user);
    }
}
