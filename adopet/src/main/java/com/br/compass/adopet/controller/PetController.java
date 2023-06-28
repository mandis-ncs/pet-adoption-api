package com.br.compass.adopet.controller;

import com.br.compass.adopet.dto.request.PetRequestDto;
import com.br.compass.adopet.dto.response.PetResponseDto;
import com.br.compass.adopet.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor //substitui o Autowired
@Slf4j
public class PetController {

//    @GetMapping
//    public String helloWorld() {
//        return "hello world";
//    }

    private final PetService service;

    //UriComponentsBuilder builder - constroi url
    //uri retorna /pet/{path variable}
    @PostMapping
    public ResponseEntity<PetResponseDto> postPet(@RequestBody @Valid PetRequestDto requestDto, UriComponentsBuilder builder){
        var response = service.postPet(requestDto);
        var uri = builder.path("/pet/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDto>> getAllPets() {
        var response = service.getAllPets();
        return ResponseEntity.ok(response);
    }

}
