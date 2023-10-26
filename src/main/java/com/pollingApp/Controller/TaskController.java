package com.pollingApp.Controller;

import com.pollingApp.Entite.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskController {

    private List<Task> tasks= new ArrayList<>();

    public List<Task> getAllTasks(){
        return tasks;
    }

}
