package com.app.ui;

import com.app.model.Task;
import com.app.service.TaskService;

import javax.swing.*;
import java.awt.*;

public class ToDoFrame extends JFrame {

    private final TaskService service;
    private final DefaultListModel<Task> listModel = new DefaultListModel<>();
    private final JList<Task> taskList = new JList<>(listModel);
    private final JTextField inputField = new JTextField();
    private final JButton addButton = new JButton("Add");
    private final JButton deleteButton = new JButton("Delete");

    public ToDoFrame(TaskService service) {
        super("ToDo - Swing App");
        this.service = service;
        initLayout();
        wireEvents();
        refreshList();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initLayout() {
        setLayout(new BorderLayout(8, 8));

        // Top: input + add button
        JPanel top = new JPanel(new BorderLayout(6, 6));
        top.add(inputField, BorderLayout.CENTER);
        top.add(addButton, BorderLayout.EAST);

        // Center: list inside a scroll pane
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(taskList);

        // Bottom: delete button
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(deleteButton);

        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    private void wireEvents() {
        // Add by button click
        addButton.addActionListener(e -> addTask());

        // Add by pressing Enter in text field
        inputField.addActionListener(e -> addTask());

        // Delete selected item
        deleteButton.addActionListener(e -> deleteSelected());
    }

    private void addTask() {
        String text = inputField.getText();
        try {
            service.add(text);
            inputField.setText("");
            refreshList();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Validation", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteSelected() {
        Task selected = taskList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Select a task to delete.",
                    "No selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        service.removeById(selected.getId());
        refreshList();
    }

    private void refreshList() {
        listModel.clear();
        for (Task t : service.getAll()) {
            listModel.addElement(t);
        }
    }
}
