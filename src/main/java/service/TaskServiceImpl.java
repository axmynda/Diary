package service;

import dao.TaskDao;
import entity.Task;
import exception.TaskDaoException;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;
    @Override
    public List<Task> getAll() throws TaskDaoException {
        return taskDao.getAll();
    }

    @Override
    public Task getEntityById(int id) throws TaskDaoException {
        return taskDao.getEntityById(id);
    }

    @Override
    public void update(Task entity) throws TaskDaoException {
        taskDao.update(entity);
    }

    @Override
    public void delete(int id) throws TaskDaoException {
     taskDao.delete(id);
    }

    @Override
    public void create(Task entity) throws TaskDaoException {
      taskDao.create(entity);
    }
}
