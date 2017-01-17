package service;


import entity.Task;
import exception.TaskDaoException;

import java.util.List;

public interface TaskService {
    List<Task> getAll() throws TaskDaoException;
    Task getEntityById(int id) throws TaskDaoException;
    void update(Task entity) throws TaskDaoException;
    void delete(int id) throws TaskDaoException;
    void create(Task entity) throws TaskDaoException;
}
