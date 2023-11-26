package com.sthien.doctor.repository;

import com.sthien.doctor.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
