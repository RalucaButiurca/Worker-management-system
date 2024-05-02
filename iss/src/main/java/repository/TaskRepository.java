package repository;

import domeniu.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> Tasks;

    public TaskRepository() {
        this.Tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        Tasks.add(task);
    }

    public Task findTask(int id) {
        for (Task task : Tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void updateTask(Task task) {
        for (int i = 0; i < Tasks.size(); i++) {
            if (Tasks.get(i).getId() == task.getId()) {
                Tasks.set(i, task);
                return;
            }
        }
    }

    public void deleteTask(Task task) {
        Tasks.remove(task);
    }

    public List<Task> getTasks() {
        return Tasks;
    }
}
