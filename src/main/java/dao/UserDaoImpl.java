package dao;

import DB.DBConnect;
import DB.IDBConnect;
import entity.User;
import exception.UserDaoException;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import static DB.SQLRequest.*;

@Component
public class UserDaoImpl implements UserDao {

    private DBConnect dbConnect = new DBConnect();


    public List<User> getAll() throws UserDaoException {
        List<User> users = new ArrayList<>();
        try{
            ResultSet resultSet = dbConnect.getStatement().executeQuery(SELECT_ALL_USERS);

            while (resultSet.next()){
                User user = new User();

                user.setId(resultSet.getInt("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setPassword(resultSet.getBytes("PASSWORD"));;
                user.setRole(resultSet.getString("ROLE"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new UserDaoException(e.getMessage());
        }
        return users;
    }

    @Override
    public User getEntityById(int id) throws UserDaoException {
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnect.getPrepareStatement(SELECT_USER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                user.setId(resultSet.getInt("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setPassword(resultSet.getBytes("PASSWORD"));
                user.setRole(resultSet.getString("ROLE"));

            }

        } catch (SQLException e) {
            throw new UserDaoException(e.getMessage());
        } finally {
            if(preparedStatement != null){
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }
        return user;
    }

    @Override
    public void update(User entity) throws UserDaoException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = dbConnect.getPrepareStatement(UPDATE_USER);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setBytes(3, entity.getPassword());
            preparedStatement.setString(4, entity.getRole());

            preparedStatement.execute();
        } catch (SQLException e) {

            throw new UserDaoException(e.getMessage());
        }finally {
            if (preparedStatement != null) {
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }
    }
    @Override
    public void delete(int id) throws UserDaoException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = dbConnect.getPrepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new UserDaoException(e.getMessage());
        }finally {
            if (preparedStatement != null) {
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }
    }
    @Override
    public void create(User entity) throws UserDaoException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = dbConnect.getPrepareStatement(INSERT_USER);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setBytes(2, entity.getPassword());
            preparedStatement.setString(3, entity.getRole());

            preparedStatement.execute();
        } catch (SQLException e) {

            throw new UserDaoException(e.getMessage());
        }finally {
            if (preparedStatement != null) {
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }
    }
}

