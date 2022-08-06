package com.ciro.springbootunittest.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ciro.springbootunittest.domain.Pet;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockVsSpyImplTest {

  @Mock
  List<Pet> petListMock = new ArrayList<>();

  @Spy
  List<Pet> petListSpy = new ArrayList<>();


  @Test
  void testMock() {
    Pet pet = Pet.builder()
        .id(1L)
        .build();

    petListMock.add(pet);

    assertEquals(0, petListMock.size());
  }

  @Test
  void testSpy() {
    Pet pet = Pet.builder()
        .id(1L)
        .build();

    petListSpy.add(pet);

    assertEquals(1, petListSpy.size());
  }
}
