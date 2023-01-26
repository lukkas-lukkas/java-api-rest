package com.medical.api.ui.http;

import com.medical.api.application.createDoctor.CreateDoctorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.api.domain.dto.CreateDoctorDto;

@RestController
@RequestMapping("doctors")
public class DoctorController {

	@Autowired
	private CreateDoctorService createDoctorService;

	@PostMapping
	@Transactional
	public String create(@RequestBody @Valid CreateDoctorDto requestBody) {
		return this.createDoctorService.create(requestBody).toString();
	}
}
