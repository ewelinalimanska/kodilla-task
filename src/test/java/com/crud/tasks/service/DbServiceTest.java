package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTasks(){

        //given
        List<Task> tasks = new ArrayList<>();

        //when
        when(repository.findAll()).thenReturn(tasks);
        List<Task> taskList = repository.findAll();

        //then
        assertEquals(0, taskList.size());

    }

    @Test
    public void testGetTask(){

        //given
        Task task = new Task(1L, "name", "content");
        dbService.saveTask(task);

        //when
        when(dbService.getTask(task.getId())).thenReturn(java.util.Optional.of(task));

        //then
        assertEquals("name", task.getTitle());
        assertEquals("content", task.getContent());

    }

    @Test
    public void testSaveTask(){

        //given
        Task task = new Task(1L, "name", "content");

        //when
        when(repository.save(task)).thenReturn(task);
        Task saveTask = repository.save(task);

        //then
        assertEquals(new Long(1), saveTask.getId());
        assertEquals("name", saveTask.getTitle());
        assertEquals("content", saveTask.getContent());
    }

    @Test
    public void testDeleteTask(){

        //given
        Task task = new Task(1L, "name", "content");

        dbService.saveTask(task);

        //when
        dbService.deleteTask(1L);

        //then
        assertEquals(0, dbService.getAllTasks().size());
    }

}