package com.app.service;

import com.app.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicInteger idSeq = new AtomicInteger(1);

    public List<Task> getAll() {
        return Collections.unmodifiableList(tasks);
    }

    public Task add(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Task cannot be blank");
        }
        Task t = new Task(idSeq.getAndIncrement(), text.trim());
        tasks.add(t);
        return t;
    }

    public boolean removeById(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }
}
