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
       
        Integer simpleTask1 = managers.addSimpleTask(new SimpleTask("1-� ������", "������� �����", NEW));
        Integer simpleTask2 = managers.addSimpleTask(new SimpleTask("2-� ������", "����� ������", NEW));

        Integer epic1 = managers.addEpic(new Epic(3,"������ ����", "��������� ���",NEW,5));
        Integer subtask1 = managers.addSubtask(new Subtask("1-� ��������� 1-�� �����", "��������� ����", NEW, epic1));
        Integer subtask2 = managers.addSubtask(new Subtask("2-� ��������� 1-�� �����", "������ �������", NEW, epic1));

        Integer epic2 = managers.addEpic(new Epic(3,"2-�� ����", "������ ������",IN_PROGRESS));
        Integer subtask3 = managers.addSubtask(new Subtask("1-� ��������� 2-�� �����", "�������� � �������", NEW, epic2));

        System.out.println("������ �����:");
        System.out.println(managers.getListEpic());
        System.out.println(managers.getListSimpleTask());
        System.out.println(managers.getListSubtask());

        managers.update(new SimpleTask(simpleTask1, "1-� ������ ���������", "������� �������� ������� ", IN_PROGRESS));
        managers.update(new Subtask(subtask1, " 1-� ��������� 1�� ����� ���������", "���� ������������ �����!", DONE, epic1));
        managers.update(new Subtask(subtask3,"1-� ��������� 2-�� �����","����� ���",IN_PROGRESS,epic2));
        managers.update(new Epic(epic2, " 2-�� ���� ��������", "������",NEW, 6));
        System.out.println("������� 1-� ������,��������� 1-�� ����� � 2-�� ����:");
        System.out.println(managers.getListSubtask());
        System.out.println(managers.getListEpic());
        System.out.println(managers.getListSimpleTask());


        //������� ������ ������ � ����
        managers.remove(simpleTask2);
       // managers.removeEpic(epic2);


        System.out.println("������ 2-�� ���� � 2-�� ������:");
        System.out.println(managers.getListEpic());
        System.out.println(managers.getListSimpleTask());
        System.out.println(managers.getListSubtask());
    }
}