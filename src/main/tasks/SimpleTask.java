package main.tasks;

import main.status.StatusEnum;


public class SimpleTask extends Task {
    public SimpleTask(String name, String description, StatusEnum status) {
        super(0, name, description, status);
    }

    public SimpleTask(Integer id, String name, String description, StatusEnum status) {
        super(id, name, description, status);
    }

    @Override
    public String toString() {
        return "SimpleTask{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + "'" +
                ", status='" + getStatus() +
                "'}";
    }

}
