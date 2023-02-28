package HomeManager.Model;

import java.io.Serializable;

public class Room implements Serializable {
    public static int numID = 0;
    private String id, name, type;
    private Boolean empty = true;

    public Room() {
    }

    public Room(String name, String type) {
        this.empty = true;
        numID += 1;
        String id = String.valueOf(numID);
        while (id.length() < 3) id = "0" + id;
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    @Override
    public String toString() {
        return this.name + " " + this.type;
    }
}
