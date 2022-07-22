package com.ciro.springbootunittest.dto.response;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetResponseDto {

  private Long id;
  private String name;
  private LocalDate birthDate;
}
