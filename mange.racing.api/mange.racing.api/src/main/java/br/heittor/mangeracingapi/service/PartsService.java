package br.heittor.mangeracingapi.service;

import br.heittor.mangeracingapi.entity.PartsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface PartsService {
    Page<PartsEntity> getAllParts(Pageable page, Specification<PartsEntity> spec);
    List<PartsEntity> saveParts(List<PartsEntity> parts);
}
