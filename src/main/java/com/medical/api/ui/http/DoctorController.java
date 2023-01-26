package com.medical.api.ui.http;

import com.medical.api.application.createDoctor.CreateDoctorResponse;
import com.medical.api.application.createDoctor.CreateDoctorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.medical.api.domain.dto.CreateDoctorDto;

@RestController
@RequestMapping("doctors")
public class DoctorController {

	@Autowired
	private CreateDoctorService createDoctorService;

	@PostMapping
	@ResponseBody
	@Transactional
	public CreateDoctorResponse create(@RequestBody @Valid CreateDoctorDto requestBody) {
		return this.createDoctorService.create(requestBody);
	}
}
