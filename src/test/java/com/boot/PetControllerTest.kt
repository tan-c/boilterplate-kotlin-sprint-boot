package com.boot

import com.boot.controller.BaseController
import com.boot.model.PetEntity
import com.boot.service.PetService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import com.boot.controller.PetController
import org.mockito.junit.MockitoJUnitRunner

import org.junit.Assert
import org.mockito.MockitoAnnotations.initMocks
import javax.persistence.EntityNotFoundException

@RunWith(MockitoJUnitRunner::class)
class PetControllerTest: BaseController() {
    @InjectMocks
    lateinit var petController: PetController

    @Mock
    var petService = PetService()

    private val petEntity = PetEntity(
        name = "1",
        gender = "male",
        owner = null
    )

    @Before
    fun init() {
        initMocks(this)
    }

    @Test
    fun shouldReturnPetResponse() {
        var petResponse = petEntity modelOf ""
        Mockito.`when`(petService.getRecord(1)).thenReturn(petResponse)

        var result = petController.getRecord(1)

        Assert.assertNotNull(result)
        Assert.assertEquals(result, getResponse(petResponse))
    }

    @Test(expected = EntityNotFoundException::class)
    fun shouldThrowException() {
        var recordId = 1L
        var petException = EntityNotFoundException("There is no entity exists with id $recordId !")

        Mockito.`when`(petService.getRecord(recordId)).thenThrow(petException)
        var result = petController.getRecord(1)
    }
}
