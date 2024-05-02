package domeniu;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    public Entity(int id) {

        this.id = id;
    }

    private int id;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}

