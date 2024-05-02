package domeniu;

public class Task extends Entity {

    private String description;
    public Task(int id, String description) {
        super(id);

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
