package com.ciro.springbootunittest.service;

import com.ciro.springbootunittest.dto.request.PetRequestDto;
import com.ciro.springbootunittest.dto.response.PetResponseDto;

public interface PetService {

  PetResponseDto savePet(PetRequestDto petRequestDto);
}
