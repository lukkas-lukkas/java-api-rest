package com.medical.api.ui.api.impl;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.ui.api.PatientController;
import com.medical.api.ui.api.facades.PatientFacade;
import com.medical.api.ui.api.requests.CreatePatientRequest;
import com.medical.api.ui.api.requests.UpdatePatientRequest;
import com.medical.api.ui.api.responses.PatientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class PatientControllerImpl implements PatientController {

    private PatientFacade facade;

    @Override
    public ResponseEntity<PatientResponse> create(CreatePatientRequest request) {
        var result = facade.create(request);
        return ResponseEntity.ok(result);
    }

    @Override
    public Page<PatientResponse> getAll(Pageable pageable) {
        return facade.getAll(pageable);
    }

    @Override
    public ResponseEntity<PatientResponse> getById(Long id) {
        try {
            var result = facade.getById(id);
            return ResponseEntity.ok(result);
        } catch (DataNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<PatientResponse> update(Long id, UpdatePatientRequest request) {
        try {
            var result = facade.update(id, request);
            return ResponseEntity.ok(result);
        } catch (DataNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void delete(Long id) {
        facade.delete(id);
    }
}
