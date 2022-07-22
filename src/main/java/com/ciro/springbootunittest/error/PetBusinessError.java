package com.ciro.springbootunittest.error;

public class PetBusinessError extends RuntimeException {

  public PetBusinessError(String message) {
    super(message);
  }
}
