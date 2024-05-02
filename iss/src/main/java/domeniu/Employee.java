package domeniu;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Entity {

    private String email;
    private String password;
    private String name;
    private Boolean present;
    private List<Task> tasks;
    public Employee(int id, String name, String password) {
        super(id);
        this.email = email;
        this.password = password;
        this.name = name;
        this.present = false;
        this.tasks = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", present=" + present + ", tasks=" + tasks;
    }
}
