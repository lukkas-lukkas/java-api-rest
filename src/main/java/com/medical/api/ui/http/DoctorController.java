package com.medical.api.ui.http;

import com.medical.api.application.createDoctor.*;
import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Doctor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.function.EntityResponse;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

	@Autowired
	private CreateDoctorService createDoctorService;
	@Autowired
	private ListDoctorService listDoctorService;

	@Autowired
	private UpdateDoctorService updateDoctorService;

	@Autowired
	private DeleteDoctorService deleteDoctorService;

	@PostMapping
	@ResponseBody
	@Transactional
	public ResponseEntity<Doctor> create(@RequestBody @Valid DoctorDto dto) {
		var doctor = this.createDoctorService.create(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}

	@GetMapping
	public List<Doctor> list() {
		return this.listDoctorService.get();
	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid DoctorDto dto) {
		try {
			var doctor = updateDoctorService.update(dto, id);

			return ResponseEntity.ok().body(doctor);
		} catch (DataNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		deleteDoctorService.delete(id);
	}
}
