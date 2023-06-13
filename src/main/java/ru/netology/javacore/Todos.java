package ru.netology.javacore;

import java.util.*;


public class Todos {
    private List<Operation> inputOperations;
    private TreeSet<String> tasks;
    private int maxQuantityTasks;

    public Todos() {
        this.tasks = new TreeSet<>();
        this.inputOperations = new ArrayList<>();
    }

    public void addInputOperations(Operation operation) {
        switch (operation.getType()) {
            case "ADD":
                inputOperations.add(operation);
                this.addTask(operation.getTask());
                break;
            case "REMOVE":
                inputOperations.add(operation);
                this.removeTask(operation.getTask());
                break;
            case "RESTORE":
                this.restoreTask();
                break;
        }
    }

    public void addTask(String task) {
        if (tasks.size() < maxQuantityTasks) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String task : tasks) {
            stringBuilder.append(task).append(" ");
        }
        String text = stringBuilder.toString();
        return text;
    }

    public void restoreTask() {
        Operation restoreOperation = inputOperations.get(inputOperations.size() - 1);
        switch (restoreOperation.getType()) {
            case "ADD":
                removeTask(restoreOperation.getTask());
                break;
            case "REMOVE":
                addTask(restoreOperation.getTask());
                break;
        }
        inputOperations.remove(inputOperations.size() - 1);
    }

    public void setMaxQuantityTasks(int maxQuantityTasks) {
        if (maxQuantityTasks > 0) {
            this.maxQuantityTasks = maxQuantityTasks;
        }
    }

    public int getMaxQuantityTasks() {
        return maxQuantityTasks;
    }

    public List<Operation> getInputOperations() {
        return inputOperations;
    }

    public TreeSet<String> getTasks() {
        return tasks;
    }
}
