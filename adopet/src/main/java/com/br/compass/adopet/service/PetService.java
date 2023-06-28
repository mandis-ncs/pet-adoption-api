package com.br.compass.adopet.service;

import com.br.compass.adopet.dto.request.PetRequestDto;
import com.br.compass.adopet.dto.response.PetResponseDto;
import com.br.compass.adopet.entity.Pet;
import com.br.compass.adopet.exception.ListIsEmptyException;
import com.br.compass.adopet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j //ajuda com o log.info
public class PetService {

    private final PetRepository petRepository;

    //recebe um request e retorna um response
    public PetResponseDto postPet(PetRequestDto requestDto) {
        log.info("### chamando post pet com nome {} ###", requestDto.nome()); //ajuda descobrir onde bugga
        var response = petRepository.save(new Pet(requestDto));
        log.info("### post pet com nome {} foi sucesso ###", requestDto.nome());
        return new PetResponseDto(response);
    }

    //retorna uma lista de registros
    public List<PetResponseDto> getAllPets() {
        var response = petRepository.findAll();
        var pets = new ArrayList<PetResponseDto>();
        if (response.isEmpty()) {
            throw new ListIsEmptyException();
        }
        response.forEach(pet -> pets.add(new PetResponseDto(pet))); //lambda
        return pets;
    }
}


//forEach com lambda
//substitui o for(pet : pets) {...}
//para cada pet adiciona a lista um novo resgistro dto