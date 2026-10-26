package com.love.repository;

import com.love.entity.Anniversary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnniversaryRepository extends JpaRepository<Anniversary, Long> {
}
