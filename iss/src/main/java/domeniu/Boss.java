package domeniu;

import javafx.concurrent.Task;

public class Boss extends Entity {

    private String email;
    private String password;
    private String name;

    public Boss(int id, String name, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
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

    public void transmitsTask(Employee Employee, Task task) {
        if(Employee.isPresent()) {
            Employee.addTask(task);
        }
    }
}
