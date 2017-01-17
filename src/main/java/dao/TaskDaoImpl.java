package dao;

import DB.IDBConnect;
import entity.Task;
import exception.TaskDaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.SQLRequest.*;


public class TaskDaoImpl implements TaskDao{

    private IDBConnect dbConnect;

    public List<Task> getAll() throws TaskDaoException {
        List<Task> tasks = new ArrayList<>();
        try{
            ResultSet resultSet = dbConnect.getStatement().executeQuery(SELECT_ALL_TASKS);

            while (resultSet.next()){
                Task task = new Task();

                task.setId(resultSet.getInt("ID"));
                task.setTask(resultSet.getString("TASK"));
                task.setDate(resultSet.getBytes("DATE"));;
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new TaskDaoException(e.getMessage());
        }
        return tasks;
    }

    @Override
    public Task getEntityById(int id) throws TaskDaoException {
        Task task = new Task();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnect.getPrepareStatement(SELECT_TASK);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                task.setId(resultSet.getInt("ID"));
                task.setTask(resultSet.getString("TASK"));
                task.setDate(resultSet.getBytes("DATE"));

            }

        } catch (SQLException e) {
            throw new TaskDaoException(e.getMessage());
        } finally {
            if(preparedStatement != null){
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }
        return task;
    }


    @Override
    public void update(Task entity) throws TaskDaoException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = dbConnect.getPrepareStatement(UPDATE_TASK);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getTask());
            preparedStatement.setBytes(3, entity.getDate());

            preparedStatement.execute();
        } catch (SQLException e) {

            throw new TaskDaoException(e.getMessage());
        }finally {
            if (preparedStatement != null) {
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }
    }



    @Override
    public void delete(int id) throws TaskDaoException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = dbConnect.getPrepareStatement(DELETE_TASK);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new TaskDaoException(e.getMessage());
        }finally {
            if (preparedStatement != null) {
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }

    }

    @Override
    public void create(Task entity) throws TaskDaoException {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = dbConnect.getPrepareStatement(INSERT_USER);
            preparedStatement.setString(1, entity.getTask());
            preparedStatement.setBytes(2, entity.getDate());
            preparedStatement.execute();
        } catch (SQLException e) {

            throw new TaskDaoException(e.getMessage());
        }finally {
            if (preparedStatement != null) {
                dbConnect.closePreparedStatement(preparedStatement);
            }
        }

    }
}
