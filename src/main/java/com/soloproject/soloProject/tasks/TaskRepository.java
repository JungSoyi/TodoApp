package com.soloproject.soloProject.tasks;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    Optional<Task> findByTitle(String title);
}
