package com.school.studenttaskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.studenttaskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}