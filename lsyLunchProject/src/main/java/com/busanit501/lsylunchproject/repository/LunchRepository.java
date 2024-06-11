package com.busanit501.lsylunchproject.repository;

import com.busanit501.lsylunchproject.domain.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LunchRepository extends JpaRepository<Lunch, Long> {
}
