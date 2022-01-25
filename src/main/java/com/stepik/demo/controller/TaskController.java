package com.stepik.demo.controller;

import com.stepik.demo.model.Task;
import com.stepik.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;


    @PostMapping( "/tasks" )
    public Task create( @RequestBody Task task )
    {
        return taskRepository.save( task );
    }

    @GetMapping( "/tasks" )
    public Iterable<Task> getTasks()
    {
        return taskRepository.findAll();
    }

    @GetMapping( "/tasks/{id}" )
    public Task getTask( @PathVariable( "id" ) long id )
    {
        return taskRepository.findById( id ).orElseThrow( () -> new RuntimeException( "not Found" ) );
    }

    @PutMapping( "/tasks/{id}" )
    public Task updateTask( @PathVariable( "id" ) long id, @RequestBody Task task )
    {
        task.setId( id );
        return taskRepository.save( task );
    }

    @PatchMapping( "/tasks/{id}:mark-as-done" )
    public void patchMethod( @PathVariable Long id )
    {
        taskRepository.markAsDone( id );
    }


    @DeleteMapping( "/tasks/{id}" )
    public void removeTask( @PathVariable( "id" ) long id )
    {
        taskRepository.deleteById( id );
    }
}
