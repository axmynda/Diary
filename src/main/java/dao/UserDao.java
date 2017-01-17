package dao;

import entity.User;
import exception.UserDaoException;

import java.util.List;


public interface UserDao {
    List<User> getAll() throws UserDaoException;
    User getEntityById(int id) throws UserDaoException;
    void update(User entity) throws UserDaoException;
    void delete(int id) throws UserDaoException;
    void create(User entity) throws UserDaoException;
}
