package com.medical.api.infrastructure.database.repository;

import com.medical.api.infrastructure.database.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
}
