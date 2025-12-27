/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academy.learnprogramming.service;
import jakarta.transaction.Transactional;
import com.academy.learnprogramming.entity.ToDo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author onasi
 */

//Transactional makes it a service
@Transactional
public class ToDoService {
    
//    Entity Manager from JPA API used to manage entities
    @PersistenceContext
    EntityManager entityManager;
    
    public ToDo createTodo(ToDo todo){
//        Persist into db and return into client
    entityManager.persist(todo);
    return todo;
    }
    
    public ToDo updateToDo(ToDo todo){
        entityManager.merge(todo);
        return todo;
    }
    
    public ToDo findTodoById(Long id){
        return entityManager.find(ToDo.class, id);
    }
    
    public List<ToDo> getTodos(){
        return entityManager.createQuery("SELECT t from Todo t", ToDo.class).getResultList();
    }
    
}
