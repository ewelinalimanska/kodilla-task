package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    public TaskMapper taskMapper = new TaskMapper();

    @Test
    void testMapToTask() {

        //given
        TaskDto taskDto = new TaskDto(1L, "test_task", "test_content");

        //when
        Task task = taskMapper.mapToTask(taskDto);

        //then
        assertEquals(1L, task.getId());
        assertEquals("test_task", task.getTitle());
        assertEquals("test_content", task.getContent());
    }

    @Test
    void testMapToTaskDto() {

        //given
        Task task = new Task(1L, "test_task", "test_content");

        //when
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //then
        assertEquals(1L, taskDto.getId());
        assertEquals("test_task", taskDto.getTitle());
        assertEquals("test_content", taskDto.getContent());
    }

    @Test
    void testMapToTaskDtoList() {

        //given
        List<Task> taskList = new ArrayList<>();

        //when
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //then
        assertEquals(0, taskDtoList.size());
    }
}