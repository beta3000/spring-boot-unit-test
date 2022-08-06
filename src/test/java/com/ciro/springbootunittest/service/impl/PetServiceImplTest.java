package com.ciro.springbootunittest.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ciro.springbootunittest.domain.Pet;
import com.ciro.springbootunittest.dto.request.PetRequestDto;
import com.ciro.springbootunittest.dto.response.PetResponseDto;
import com.ciro.springbootunittest.error.PetBusinessError;
import com.ciro.springbootunittest.repository.PetRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetServiceImplTest {
  @Mock
  PetRepository petRepository;
  @InjectMocks
  PetServiceImpl petService;

  PetRequestDto petRequestDto = new PetRequestDto();

  @BeforeEach
  void setUp() {
    System.out.println("BeforeEach");
    petRequestDto.setBirthDate(LocalDate.now());
    petRequestDto.setName("");
  }

  @Test
  void savePet_Throws_BusinessException() {
    //Arrange

    //Act

    //Assert
    assertThrows(PetBusinessError.class, () -> petService.savePet(petRequestDto));
  }

  @Test
  @DisplayName("La mascota se ha guardado correctamene")
  void savePet_OK(){
    //Arrange
    petRequestDto.setName("name");

    //Act
    when(petRepository.save(any(Pet.class))).thenReturn(Pet.builder()
        .id(1L)
        .birthDate(LocalDate.now())
        .name("no_name")
        .build());

    PetResponseDto petResponseDto = petService.savePet(petRequestDto);

    //Assert
    assertEquals("no_name", petResponseDto.getName());
  }

  @Test
  void savePet_Verify(){
    //Arrange
    petRequestDto.setName("name");

    when(petRepository.save(any(Pet.class))).thenReturn(Pet.builder()
        .id(1L)
        .birthDate(LocalDate.now())
        .name("no_name")
        .build());

    //Act
    PetResponseDto petResponseDto = petService.savePet(petRequestDto);

    //Assert
    verify(petRepository, times(1)).save(any(Pet.class));
  }
}
