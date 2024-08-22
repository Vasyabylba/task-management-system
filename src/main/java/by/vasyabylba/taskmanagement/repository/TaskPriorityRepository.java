package by.vasyabylba.taskmanagement.repository;

import by.vasyabylba.taskmanagement.model.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Long> {
    Optional<TaskPriority> findByNameIgnoreCase(String name);
}