package com.boot

import com.boot.controller.ApiResponse
import com.boot.controller.BaseController
import com.boot.model.PetEntity
import com.boot.model.PetRepository
import com.boot.service.PetService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

import com.boot.controller.PetController
import com.boot.model.PetResponseModel
import org.mockito.junit.MockitoJUnitRunner

import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.`is`
import org.junit.Assert
import org.springframework.http.ResponseEntity

@RunWith(MockitoJUnitRunner::class)
class PetControllerTest: BaseController() {
    @InjectMocks
    lateinit var petController: PetController

    @Mock
    lateinit var petService: PetService

    @Mock
    lateinit var petRepository: PetRepository

    private val petResponse = PetResponseModel(
        name = "1",
        gender = "male",
        owner = null
    )

    @Before
    fun init() {
//        MockitoAnnotations.initMocks(this)
        Mockito.`when`(petService.getRecord(1)).thenReturn(petResponse)
    }

    @Test
    fun testPetController() {
        var result = petController.getRecord(1)
        Assert.assertNotNull(result)
        Assert.assertEquals(result, getResponse(petResponse))

//        val petEntity = PetEntity()
//        petEntity.id = 1L
//
//        Mockito.`when`(petRepository.findById(1L)).thenReturn(petEntity!)
//
//
//        Assert.verify(petRepository).findById(1L)
//
//        Assert.assertEquals(1L, petEntity.id)
//        Assert.assertThat(petEntity.id, `is`<T>(1L))
    }
}
