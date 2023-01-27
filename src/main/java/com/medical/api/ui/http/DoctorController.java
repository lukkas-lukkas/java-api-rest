package com.medical.api.ui.http;

import com.medical.api.application.createDoctor.CreateDoctorService;
import com.medical.api.application.createDoctor.ListDoctorService;
import com.medical.api.domain.models.Doctor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.medical.api.application.createDoctor.DoctorDto;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

	@Autowired
	private CreateDoctorService createDoctorService;
	@Autowired
	private ListDoctorService listDoctorService;

	@PostMapping
	@ResponseBody
	@Transactional
	public Doctor create(@RequestBody @Valid DoctorDto dto) {
		return this.createDoctorService.create(dto);
	}

	@GetMapping
	public List<Doctor> list() {
		return this.listDoctorService.get();
	}
}
