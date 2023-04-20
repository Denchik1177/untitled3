package main.tasks;

import main.status.StatusEnum;

public class Subtask extends Task {
    private final Integer epicID;

    public Subtask(String name, String description, StatusEnum status, Integer epicID) {
        super(0, name, description, status);
        this.epicID = epicID;
    }

    public Subtask(Integer id, String name, String description, StatusEnum status, Integer epicID) {
        super(id, name, description, status);
        this.epicID = epicID;
    }


    public Integer getEpicID() {
        return epicID;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", epicID=" + epicID +
                ", status='" + getStatus() +
                "'}";
    }

}
