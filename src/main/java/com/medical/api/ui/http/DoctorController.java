package com.medical.api.ui.http;

import com.medical.api.application.doctor.dto.DoctorDto;
import com.medical.api.application.doctor.dto.UpdateDoctorDto;
import com.medical.api.application.shared.*;
import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {

	private final PersistenceServiceBuilder<Doctor> serviceBuilder;

	public DoctorController (DoctorRepository repository) {
		this.serviceBuilder = new PersistenceServiceBuilder<Doctor>(repository);
	}

	@PostMapping
	@ResponseBody
	@Transactional
	public ResponseEntity<Doctor> create(@RequestBody @Valid DoctorDto dto) {
		var doctor = this.serviceBuilder.getCreateService().create(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}

	@GetMapping
	public Page<Doctor> list(Pageable pageable) {
		return this.serviceBuilder.getListService().get(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getById(@PathVariable Long id) {
		try {
			var doctor = this.serviceBuilder.getGetService().getById(id);

			return ResponseEntity.ok().body(doctor);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid DoctorDto dto) {
		try {
			var doctor = this.serviceBuilder.getUpdateService().update(dto, id);

			return ResponseEntity.ok().body(doctor);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateFields(@PathVariable Long id, @RequestBody @Valid UpdateDoctorDto dto) {
		try {
			var doctor = this.serviceBuilder.getUpdateService().update(dto, id);

			return ResponseEntity.ok().body(doctor);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.serviceBuilder.getDeleteService().delete(id);
	}
}
