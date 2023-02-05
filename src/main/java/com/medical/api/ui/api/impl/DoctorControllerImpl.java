package com.medical.api.ui.api.impl;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.ui.api.DoctorController;
import com.medical.api.ui.api.facades.DoctorFacade;
import com.medical.api.ui.api.requests.CreateDoctorRequest;
import com.medical.api.ui.api.requests.UpdateDoctorRequest;
import com.medical.api.ui.api.responses.DoctorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class DoctorControllerImpl implements DoctorController {

    private DoctorFacade facade;

    @Override
    public ResponseEntity<DoctorResponse> create(CreateDoctorRequest request) {
        var result = facade.create(request);
        return ResponseEntity.ok(result);
    }

    @Override
    public Page<DoctorResponse> getAll(Pageable pageable) {
        return facade.getAll(pageable);
    }

    @Override
    public ResponseEntity<DoctorResponse> getById(Long id) {
        try {
            var result = facade.getById(id);
            return ResponseEntity.ok(result);
        } catch (DataNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<DoctorResponse> update(Long id, UpdateDoctorRequest request) {
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
