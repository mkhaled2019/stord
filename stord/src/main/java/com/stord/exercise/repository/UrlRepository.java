package com.stord.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stord.exercise.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}
