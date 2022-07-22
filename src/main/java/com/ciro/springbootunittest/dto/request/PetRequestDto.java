package com.ciro.springbootunittest.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PetRequestDto {

  private Long id;
  private String name;
  private LocalDate birthDate;
}
