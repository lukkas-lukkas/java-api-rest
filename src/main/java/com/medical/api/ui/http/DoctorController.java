package com.medical.api.ui.http;

import com.medical.api.application.doctor.dto.DoctorDto;
import com.medical.api.application.doctor.dto.UpdateDoctorDto;
import com.medical.api.application.shared.*;
import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.database.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {

	private final PersistenceFacade<Doctor> persistenceFacade;

	@Autowired
	public DoctorController (DoctorRepository repository) {
		this.persistenceFacade = new PersistenceFacade<>(repository);
	}

	@PostMapping
	@ResponseBody
	@Transactional
	public ResponseEntity<Doctor> create(@RequestBody @Valid DoctorDto dto) {
		var doctor = this.persistenceFacade.create(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}

	@GetMapping
	public Page<Doctor> list(Pageable pageable) {
		return this.persistenceFacade.list(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getById(@PathVariable Long id) {
		try {
			var doctor = this.persistenceFacade.get(id);

			return ResponseEntity.ok().body(doctor);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid DoctorDto dto) {
		try {
			var doctor = this.persistenceFacade.update(dto, id);

			return ResponseEntity.ok().body(doctor);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateFields(@PathVariable Long id, @RequestBody @Valid UpdateDoctorDto dto) {
		try {
			var doctor = this.persistenceFacade.update(dto, id);

			return ResponseEntity.ok().body(doctor);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.persistenceFacade.delete(id);
	}
}
