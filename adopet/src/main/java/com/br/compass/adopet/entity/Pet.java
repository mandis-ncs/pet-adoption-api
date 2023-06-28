package com.br.compass.adopet.entity;

import com.br.compass.adopet.dto.request.PetRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity - type used by MySql
    private Long id;
    private String nome;
    private String idade;
    private String descricao;

    public Pet(PetRequestDto requestDto) {
        this.nome = requestDto.nome();
        this.idade = requestDto.idade();
        this.descricao = requestDto.descricao();
    }

}
