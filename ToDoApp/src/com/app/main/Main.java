package com.app.main;

import com.app.service.TaskService;
import com.app.ui.ToDoFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {            // [8]
            TaskService service = new TaskService();  // [9]
            new ToDoFrame(service);                   // [10]
        });
    }
}