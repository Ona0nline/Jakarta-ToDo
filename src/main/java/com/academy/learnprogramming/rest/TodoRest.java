/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academy.learnprogramming.rest;

import com.academy.learnprogramming.entity.ToDo;
import com.academy.learnprogramming.service.ToDoService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.inject.Inject;

/**
 *
 * @author onasi
 */

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {
    
    @Inject
    ToDoService toDoService;
    
    @Path("new")
    @POST
    public Response createTodo(ToDo todo){
//        api/v1/todo/new
    toDoService.createTodo(todo);
    return Response.ok(todo).build();
    }
    
    @Path("update")
    @PUT
    public Response updateTodo(ToDo todo){
        toDoService.updateToDo(todo);
        return Response.ok(todo).build();

    }
    
    @Path("{id}")
    @GET
    public ToDo getTodo(@PathParam("id") Long id){
        return toDoService.findTodoById(id);
    }
    
    @Path("list")
    @GET
    public List<ToDo> getTodos(){
        return toDoService.getTodos();
    }
    
}
