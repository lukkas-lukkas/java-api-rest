package com.medical.api.domain.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseGateway<Domain> {
    Domain insert(Domain domain);

    void delete(Long id);

    Optional<Domain> getById(Long id);

    Page<Domain> getAll(Pageable pageable);

    List<Domain> getAll();

    Domain update(Domain domain);
}
