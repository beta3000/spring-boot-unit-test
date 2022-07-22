package com.ciro.springbootunittest.service.impl;

import com.ciro.springbootunittest.domain.Pet;
import com.ciro.springbootunittest.dto.request.PetRequestDto;
import com.ciro.springbootunittest.dto.response.PetResponseDto;
import com.ciro.springbootunittest.error.PetBusinessError;
import com.ciro.springbootunittest.repository.PetRepository;
import com.ciro.springbootunittest.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

  private final PetRepository petRepository;

  public PetServiceImpl(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public PetResponseDto savePet(PetRequestDto petRequestDto) {
    validatePet(petRequestDto);

    Pet pet = petRepository.save(Pet
        .builder()
        .name(petRequestDto.getName())
        .birthDate(petRequestDto.getBirthDate())
        .build());

    return PetResponseDto.builder()
        .id(pet.getId())
        .name(pet.getName())
        .birthDate(pet.getBirthDate())
        .build();
  }

  private void validatePet(PetRequestDto petRequestDto) {
    if (petRequestDto.getName().isEmpty()) {
      throw new PetBusinessError("Name no puede ser empty");
    }
  }
}
