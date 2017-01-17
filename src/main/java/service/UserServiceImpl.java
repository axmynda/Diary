package service;


import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserDaoException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAll() throws UserDaoException {
        return userDao.getAll();
    }

    @Override
    public User getEntityById(int id) throws UserDaoException {
        return userDao.getEntityById(id);
    }

    @Override
    public void update(User entity) throws UserDaoException {
        userDao.update(entity);
    }

    @Override
    public void delete(int id) throws UserDaoException {
        userDao.delete(id);
    }

    @Override
    public void create(User entity) throws UserDaoException {
        userDao.create(entity);
    }
}
