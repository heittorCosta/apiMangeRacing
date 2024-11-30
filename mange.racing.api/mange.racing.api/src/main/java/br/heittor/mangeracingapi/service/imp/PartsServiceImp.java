package br.heittor.mangeracingapi.service.imp;

import br.heittor.mangeracingapi.entity.PartsEntity;
import br.heittor.mangeracingapi.repository.PartsRepository;
import br.heittor.mangeracingapi.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsServiceImp  implements PartsService {
    @Autowired
    PartsRepository partsRepository;

    @Override
    public Page<PartsEntity> getAllParts(Pageable page, Specification<PartsEntity> spec) {
        return partsRepository.findAll(spec, page);
    }

    @Override
    public List<PartsEntity> saveParts(List<PartsEntity> parts) {
        return partsRepository.saveAll(parts);
    }
}
