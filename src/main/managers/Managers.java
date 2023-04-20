package main.managers;

import main.tasks.Epic;
import main.tasks.SimpleTask;
import main.tasks.Subtask;

import java.util.*;

import static main.status.StatusEnum.*;


public class Managers{
    private Integer nextID;
    private final Map<Integer, SimpleTask> simpleTasks;
    private final Map<Integer, Subtask> subtasks;
    private final Map<Integer, Epic> epics;


    public Managers() {
        this.nextID = 1;
        this.simpleTasks = new HashMap<>();
        this.subtasks = new HashMap<>();
        this.epics = new HashMap<>();

    }

    private void updateEpicStatus(Integer epicID) {

        Integer countOfNEW = 0;
        Integer countOfDONE = 0;
        Integer countOfSubtask =  epics.get(epicID).getSubtaskIDs().size();

        for (Integer subtaskID : epics.get(epicID).getSubtaskIDs()) {
            if (subtasks.get(subtaskID).getStatus() == NEW) {
                countOfNEW++;
            } else if (subtasks.get(subtaskID).getStatus() == DONE) {
                countOfDONE++;
            }
        }

        if (countOfNEW.equals(countOfSubtask) || (countOfSubtask == 0)) {
            Epic epic = epics.get(epicID);
            epic.setStatus(NEW);
            epics.put(epicID, epic);
        } else if (countOfDONE.equals(countOfSubtask)) {
            Epic epic = epics.get(epicID);
            epic.setStatus(DONE);
            epics.put(epicID, epic);
        } else {
            Epic epic = epics.get(epicID);
            epic.setStatus(IN_PROGRESS);
            epics.put(epicID, epic);
        }
    }
    public void removeSubtask(Integer id) {
        subtasks.remove(id);
    }


    public void removeEpic(Integer id) {
        for (Integer subtaskID : epics.get(id).getSubtaskIDs()) {
            subtasks.remove(subtaskID);
        }
        epics.remove(id);
//        if(subtasks.containsKey())
//            if (Objects.equals(subtasks.get(key).getEpicID(), id)) {
//                subtasks.remove(key);
//                if (subtasks.size() <= 1) {
//                    subtasks.clear();
//                    break;
                }





    public List<SimpleTask> getListSimpleTask() {
        List<SimpleTask> list = new ArrayList<>(simpleTasks.values());
        return list;
    }


    public List<Subtask> getListSubtask() {
        List<Subtask> list = new ArrayList<>(subtasks.values());
        return list;
    }


    public List<Epic> getListEpic() {
        List<Epic> list = new ArrayList<>(epics.values());
        return list;
    }


    public Integer addSimpleTask(SimpleTask task) {
        task.setId(nextID++);
        simpleTasks.put(task.getId(), task);
        return task.getId();
    }


    public Integer addSubtask(Subtask task,Integer epicId) {
        task.setId(nextID++);
        subtasks.put(task.getId(), task);
        Epic epic = epics.get(epicId);
        epic.getSubtaskIDs().add(task.getId());

        return task.getId();
    }


    public Integer addEpic(Epic epic,Set<Integer>subtasks) {
        epic.setId(nextID++);
        epic.setStatus(NEW);
        epic.getSubtaskIDs().addAll(subtasks);
        epics.put(epic.getId(), epic);
        return epic.getId();
    }


    public void update(SimpleTask task) {
        simpleTasks.put(task.getId(), task);
    }


    public void update(Subtask subtask) {

        subtasks.put(subtask.getId(), subtask);
        updateEpicStatus(subtask.getEpicID());
    }


    public void update(Epic epic) {
        epics.put(epic.getId(), epic);
        updateEpicStatus(epic.getId());
    }


    public void removeAllSimpleTasks() {
        simpleTasks.clear();
    }


    public void removeAllSubtasks() {
        subtasks.clear();
    }


    public void removeAllEpics() {
        epics.clear();
        subtasks.clear();
    }


    public void removeAll() {
        simpleTasks.clear();
        subtasks.clear();
        epics.clear();
    }


    public void removeSimpleTask(Integer id) {
        if (simpleTasks.containsKey(id)) {
            simpleTasks.remove(id);
        }
    }
}


