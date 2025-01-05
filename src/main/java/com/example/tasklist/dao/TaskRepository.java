package com.example.tasklist.dao;

import com.example.tasklist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface TaskRepository extends JpaRepository<Task, Long> {
}
