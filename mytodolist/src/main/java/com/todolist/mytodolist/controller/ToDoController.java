package com.todolist.mytodolist.controller;

import com.todolist.mytodolist.model.ToDoItem;
import com.todolist.mytodolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping (value = "/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping
    public List<ToDoItem> findAll(){
        return toDoRepository.findAll();
    }

    @PostMapping
    public Object save (@Valid @NotNull @RequestBody ToDoItem toDoItem){
        return toDoRepository.save(toDoItem);

    }

    @PutMapping
    public Object update (@Valid @NotNull @RequestBody ToDoItem toDoItem){
        return toDoRepository.save(toDoItem);
    }

    @DeleteMapping (value = "/{id}")
    public void delete (@PathVariable Long id){
        toDoRepository.deleteById(id);
    }
}
