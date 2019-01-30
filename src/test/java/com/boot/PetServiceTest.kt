package com.boot

import com.boot.model.PetEntity
import com.boot.model.PetRepository
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import com.boot.controller.PetController
import com.boot.service.PetService

class PetControllerTest {
    @InjectMocks
    lateinit var petService: PetService

    @Test
    fun testShipwreckGet() {
        val pet = petService.getRecord(1)
        pet.id = 1L
        //		when(petRepository.findById(1l)).thenReturn(pet);
        //
        //		PetEntity wreck = petController.get(1L);
        //
        //		verify(petRepository).findById(1l);
        //
        //		assertEquals(1l, pet.getId().longValue());
        //		assertThat(pet.getId(), is(1l));
    }
}
