package by.vasyabylba.taskmanagement.repository;

import by.vasyabylba.taskmanagement.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    Optional<TaskStatus> findByNameIgnoreCase(String name);
}