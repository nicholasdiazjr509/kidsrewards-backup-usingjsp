package com.codeup.kidsrewardscapstone.repositories;

import com.codeup.kidsrewardscapstone.models.Task;
import com.codeup.kidsrewardscapstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
