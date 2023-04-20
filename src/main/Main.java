package main;



import main.managers.Managers;
import main.tasks.Epic;
import main.tasks.SimpleTask;
import main.tasks.Subtask;

import java.util.Set;

import static main.status.StatusEnum.*;


public class Main {
    public static void main(String[] args) {

        Managers managers = new Managers();
       
        Integer simpleTask1 = managers.addSimpleTask(new SimpleTask("1-я Задача", "Выучить джаву", NEW));
        Integer simpleTask2 = managers.addSimpleTask(new SimpleTask("2-я Задача", "Найти работу", NEW));

        Integer epic1 = managers.addEpic(new Epic(3,"Первый эпик", "Построить дом",NEW,5));
        Integer subtask1 = managers.addSubtask(new Subtask("1-я Подзадача 1-го Эпика", "Составить план", NEW, epic1));
        Integer subtask2 = managers.addSubtask(new Subtask("2-я Подзадача 1-го Эпика", "Купить кирпичи", NEW, epic1));

        Integer epic2 = managers.addEpic(new Epic(3,"2-ой Эпик", "Купить машину",IN_PROGRESS));
        Integer subtask3 = managers.addSubtask(new Subtask("1-я Подзадача 2-го Эпика", "Выиграть в лотерее", NEW, epic2));

        System.out.println("Трекер задач:");
        System.out.println(managers.getListEpic());
        System.out.println(managers.getListSimpleTask());
        System.out.println(managers.getListSubtask());

        managers.update(new SimpleTask(simpleTask1, "1-я Задача обновлена", "Процесс обучение запущен ", IN_PROGRESS));
        managers.update(new Subtask(subtask1, " 1-я подзадача 1го Эпика обновлена", "План сроительства готов!", DONE, epic1));
        managers.update(new Subtask(subtask3,"1-я Подзадача 2-го Эпика","Денег нет",IN_PROGRESS,epic2));
        managers.update(new Epic(epic2, " 2-ой Эпик обновлен", "Машина",NEW, 6));
        System.out.println("Обновим 1-ю задачу,подзадачу 1-го эпика и 2-ой эпик:");
        System.out.println(managers.getListSubtask());
        System.out.println(managers.getListEpic());
        System.out.println(managers.getListSimpleTask());


        //Удаляем вторую задачу и эпик
        managers.remove(simpleTask2);
       // managers.removeEpic(epic2);


        System.out.println("Удалим 2-ой Эпик и 2-ую Задачу:");
        System.out.println(managers.getListEpic());
        System.out.println(managers.getListSimpleTask());
        System.out.println(managers.getListSubtask());
    }
}