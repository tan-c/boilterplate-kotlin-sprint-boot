package com.boot;

import com.boot.model.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;

	@Mock
	private ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testShipwreckGet() {
//    	Shipwreck sw = new Shipwreck();
//    	sw.setId(1l);
//		when(shipwreckRepository.findById(1l)).thenReturn(sw);
//
//		Shipwreck wreck = sc.get(1L);
//
//		verify(shipwreckRepository).findById(1l);
//
//		assertEquals(1l, wreck.getId().longValue());
//		assertThat(wreck.getId(), is(1l));
	}

}
