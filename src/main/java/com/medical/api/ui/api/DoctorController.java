package com.medical.api.ui.api;

import com.medical.api.ui.api.requests.CreateDoctorRequest;
import com.medical.api.ui.api.requests.UpdateDoctorRequest;
import com.medical.api.ui.api.responses.DoctorResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public interface DoctorController {

    @PostMapping
    @ResponseBody
    @Transactional
    ResponseEntity<DoctorResponse> create(@RequestBody @Valid CreateDoctorRequest request);

    @GetMapping
    Page<DoctorResponse> getAll(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<DoctorResponse> getById(@PathVariable Long id);

    @Transactional
    @PutMapping("/{id}")
    ResponseEntity<DoctorResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateDoctorRequest request);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
