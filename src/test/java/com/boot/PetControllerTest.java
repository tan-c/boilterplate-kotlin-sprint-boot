package com.boot;

import com.boot.model.PetEntity;
import com.boot.model.PetRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.PetController;

public class PetControllerTest {
	@InjectMocks
	private PetController petController;

	@Mock
	private PetRepository petRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testShipwreckGet() {
    	PetEntity pet = new PetEntity();
        pet.setId(1l);
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
