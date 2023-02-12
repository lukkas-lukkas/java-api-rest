package com.medical.api.infrastructure.database.repository;

import com.medical.api.infrastructure.database.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
