package com.medical.api.infrastructure.persistence;

import com.medical.api.domain.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
