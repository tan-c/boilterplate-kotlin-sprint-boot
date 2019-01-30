package com.boot

import com.boot.model.PetEntity
import com.boot.model.PetRepository
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import com.boot.controller.PetController
import com.boot.model.PetResponseModel
import com.boot.service.PetService
import org.junit.Assert
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner::class)
//@SpringBootTest(classes = [App::class])
@RunWith(MockitoJUnitRunner::class)
class PetServiceTest {
    @Mock
    lateinit var petService: PetService

    @Test
    fun testShipwreckGet() {
        val petResponse = PetResponseModel(
            name = "1",
            gender = "male",
            owner = null
        )
        Mockito.`when`(petService.getRecord(1)).thenReturn(petResponse)
        val testResult = petService.getRecord(1)
        Assert.assertEquals(petResponse, testResult)
    }
}
