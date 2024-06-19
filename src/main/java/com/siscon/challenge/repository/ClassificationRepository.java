package com.siscon.challenge.repository;

import com.siscon.challenge.entities.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Integer> {
}