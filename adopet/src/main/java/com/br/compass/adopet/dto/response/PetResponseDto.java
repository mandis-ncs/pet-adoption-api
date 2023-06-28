package com.br.compass.adopet.dto.response;

import com.br.compass.adopet.entity.Pet;


//classe PetResponseDto retorna o pet criado
public record PetResponseDto(
        Long id,
        String nome,
        String idade,
        String descricao
) {

    //constructor receive entity and transform in responseDto
    public PetResponseDto(Pet response) {
        this(response.getId(), response.getNome(), response.getIdade(), response.getDescricao());
    }
}


//record - guarda informações, não usa setter, nao pode ser entity, usado como DTO
//contain fields, all-args constructor, getters, toString, and equals/hashCode methods