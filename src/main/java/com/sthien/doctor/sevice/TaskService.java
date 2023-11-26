package com.sthien.doctor.sevice;

import com.sthien.doctor.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public List<Task> getAllTasks();

    public Optional<Task> getTaskById(Long id);

    public Task createTask(Task task);

    public Task updateTask(Task task);

    public void deleteTaskById(Long id);
}
