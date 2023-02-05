package com.medical.api.ui.api;

import com.medical.api.ui.api.requests.CreatePatientRequest;
import com.medical.api.ui.api.requests.UpdatePatientRequest;
import com.medical.api.ui.api.responses.PatientResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public interface PatientController {

    @PostMapping
    @ResponseBody
    @Transactional
    ResponseEntity<PatientResponse> create(@RequestBody @Valid CreatePatientRequest request);

    @GetMapping
    Page<PatientResponse> getAll(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<PatientResponse> getById(@PathVariable Long id);

    @Transactional
    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UpdatePatientRequest request);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
