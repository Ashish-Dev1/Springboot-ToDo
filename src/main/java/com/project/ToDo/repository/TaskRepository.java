package com.project.ToDo.repository;

import com.project.ToDo.model.Task;
import com.project.ToDo.model.TaskStatus;
import com.project.ToDo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT t FROM Task t JOIN t.user u WHERE u.username = :username AND t.status= :status")
    List<Task> findUserAndStatus(@Param("username") String username,@Param("status") TaskStatus status);
    boolean existsTaskById(Long id);
}
