package com.br.compass.adopet.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetRequestDto (
        @NotNull //usando o Validation package
        @NotBlank
        String nome,

        @NotNull
        @NotBlank
        String idade,

        @NotNull
        @NotBlank
        String descricao
){
}
