package com.medical.api.ui.http;

import com.medical.api.application.patient.dto.PatientDto;
import com.medical.api.application.patient.dto.UpdatePatientDto;
import com.medical.api.application.shared.PersistenceFacade;
import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Patient;
import com.medical.api.infrastructure.persistence.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientController {

	private final PersistenceFacade<Patient> serviceBuilder;

	public PatientController(PatientRepository repository) {
		this.serviceBuilder = new PersistenceFacade<Patient>(repository);
	}

	@PostMapping
	@ResponseBody
	@Transactional
	public ResponseEntity<Patient> create(@RequestBody @Valid PatientDto dto) {
		var Patient = this.serviceBuilder.getCreateService().create(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(Patient);
	}

	@GetMapping
	public Page<Patient> list(Pageable pageable) {
		return this.serviceBuilder.getListService().get(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getById(@PathVariable Long id) {
		try {
			var Patient = this.serviceBuilder.getGetService().getById(id);

			return ResponseEntity.ok().body(Patient);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid PatientDto dto) {
		try {
			var Patient = this.serviceBuilder.getUpdateService().update(dto, id);

			return ResponseEntity.ok().body(Patient);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateFields(@PathVariable Long id, @RequestBody @Valid UpdatePatientDto dto) {
		try {
			var Patient = this.serviceBuilder.getUpdateService().update(dto, id);

			return ResponseEntity.ok().body(Patient);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.serviceBuilder.getDeleteService().delete(id);
	}
}
