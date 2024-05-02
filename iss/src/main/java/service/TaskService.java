package service;

import domeniu.Task;
import repository.TaskRepository;

import java.util.List;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public Task findTask(int id) {
        return taskRepository.findTask(id);
    }

    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    public void deleteTask(Task task) {
        taskRepository.deleteTask(task);
    }

    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }
}
