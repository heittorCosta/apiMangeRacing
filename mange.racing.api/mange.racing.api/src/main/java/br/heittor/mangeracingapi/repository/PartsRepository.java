package br.heittor.mangeracingapi.repository;

import br.heittor.mangeracingapi.entity.PartsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface PartsRepository extends JpaRepository<PartsEntity, UUID>, JpaSpecificationExecutor<PartsEntity> {
    //faz a busca obedecendo filtros!
    List<PartsEntity> findAll(Specification<PartsEntity> spec);

    //faz a busca obedecendo filtros e ainda paginação!
    Page<PartsEntity> findAll(Specification<PartsEntity> spec, Pageable pageable);
}
