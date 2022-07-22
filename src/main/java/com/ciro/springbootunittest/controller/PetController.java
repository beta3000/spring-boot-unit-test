package com.ciro.springbootunittest.controller;

import com.ciro.springbootunittest.dto.request.PetRequestDto;
import com.ciro.springbootunittest.dto.response.PetResponseDto;
import com.ciro.springbootunittest.service.PetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pets")
public class PetController {

  private final PetService petService;

  public PetController(PetService petService) {
    this.petService = petService;
  }

  @PostMapping(path = "")
  public PetResponseDto savePet(@RequestBody PetRequestDto petRequestDto) {
    return petService.savePet(petRequestDto);
  }
}
