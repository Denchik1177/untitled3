package main.tasks;

import main.status.StatusEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Epic extends Task {
    private Set<Integer> subtaskIDs;

    public Epic(String name, String description) {
        super(0, name, description);
        subtaskIDs = new HashSet<>();
    }

    public Epic(Integer id, String name, String description, StatusEnum status) {
        super(id, name, description, status);
        subtaskIDs = new HashSet<>();
    }

    public Epic(Integer id, String name, String description, StatusEnum status, Set<Integer> subtaskIDs) {
        super(id, name, description, status);
        this.subtaskIDs = subtaskIDs;
    }
//    public Epic(Integer id, String name, String description) {
//        super(id, name, description);
//        subtaskIDs = new HashSet<>();
//    }


    public Set<Integer> getSubtaskIDs() {
        return subtaskIDs;
    }

    public void setSubtaskIDs(Set<Integer> subtaskIDs) {
        this.subtaskIDs = subtaskIDs;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + "'" +
                ", subtaskIDs=" + subtaskIDs +
                ", status='" + getStatus() + "'" +
                '}';
    }
}
