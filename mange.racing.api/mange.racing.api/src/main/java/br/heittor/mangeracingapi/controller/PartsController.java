package br.heittor.mangeracingapi.controller;

import br.heittor.mangeracingapi.entity.BikeType;
import br.heittor.mangeracingapi.entity.PartsEntity;
import br.heittor.mangeracingapi.model.PartsInputModel;
import br.heittor.mangeracingapi.service.PartsService;
import br.heittor.mangeracingapi.specifications.PartsSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike/parts")
@CrossOrigin(origins = "*")
public class PartsController {
    @Autowired
    PartsService partsService;

    @GetMapping("/{bikeType}")
    public ResponseEntity<Page<PartsEntity>> getAllParts(@PathVariable  BikeType bikeType,
                                                         Pageable pageable,
                                                         PartsSpecification.PartsSpec spec) {
        if (spec != null) {
            spec.and(Specification.where(PartsSpecification.bikeTypeEquals(bikeType)));
        }
        Page<PartsEntity> parts = partsService.getAllParts(pageable, spec);

        return ResponseEntity.ok(parts);
    }

    @PostMapping("/{bikeType}")
    public ResponseEntity<List<PartsEntity>> addNewParts(
            @PathVariable BikeType bikeType,
            @RequestBody @Valid List<PartsInputModel> parts
    ) {

        List<PartsEntity> partsEntities = parts.stream().map(input -> {
            PartsEntity convertedPart = new PartsEntity(bikeType);
            BeanUtils.copyProperties(input, convertedPart);
            return convertedPart;
        }).toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(partsService.saveParts(partsEntities));
    }
}
