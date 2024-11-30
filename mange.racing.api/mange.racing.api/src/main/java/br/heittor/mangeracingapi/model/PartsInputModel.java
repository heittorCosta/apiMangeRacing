package br.heittor.mangeracingapi.model;

import br.heittor.mangeracingapi.entity.PartType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PartsInputModel(
        @NotBlank
        String title,

        @NotNull
        String image,

        @NotNull
        PartType type
) {
}