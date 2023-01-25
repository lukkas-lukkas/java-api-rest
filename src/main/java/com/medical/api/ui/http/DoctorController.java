package com.medical.api.ui.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.api.domain.dto.CreateDoctorDto;

@RestController
@RequestMapping("doctors")
public class DoctorController {
	
	@PostMapping
	public String create(@RequestBody CreateDoctorDto requestBody) {
		return requestBody.toString();
	}
}
