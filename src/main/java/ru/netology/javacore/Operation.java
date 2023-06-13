package ru.netology.javacore;

public class Operation {
    private String type;
    private String task;

    public Operation(String type, String task) {
        this.type = type;
        this.task = task;
    }

    public Operation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }
}
