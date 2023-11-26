package com.sthien.doctor.controller;


import com.sthien.doctor.entity.Task;
import com.sthien.doctor.sevice.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() throws Exception {
        try{
            List<Task> taskList = taskService.getAllTasks();
            return ResponseEntity.ok(taskList);
        } catch (Exception e) {
            throw new Exception("Cant get all tasks", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable Long id) throws Exception{
        try {
            Optional<Task> taskOptional = taskService.getTaskById(id);
            if (!taskOptional.isPresent()) {
                return new ResponseEntity<>("Can not find the task with id: " + id, HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(taskOptional.get());

        } catch (Exception e) {
            throw new Exception("Can't find the task with id: " + id, e);
        }    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) throws Exception{
        try {
            Task taskResponse = taskService.createTask(task);
            if (taskResponse != null) {
                return ResponseEntity.ok(taskResponse);
            }
            return new ResponseEntity("Create Unsuccessful ", HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            throw new Exception("Create Unsuccessful");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) throws Exception{
        try {
            Optional<Task> taskOptional = taskService.getTaskById(id);
            return taskOptional.map(task1 -> {
                task.setId(task1.getId());
                return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.OK);
            }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e){
            throw new Exception("Fail update ", e);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTaskById(@PathVariable long id) throws Exception{
        try {
            taskService.deleteTaskById(id);
            return ResponseEntity.ok("deleted successfully");
        } catch (Exception e) {
            throw new Exception("Fail delete ", e);
        }
    }
}
