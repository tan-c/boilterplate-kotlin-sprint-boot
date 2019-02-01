package com.boot

import com.boot.controller.BaseController
import com.boot.model.OwnerEntity
import com.boot.service.OwnerService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import com.boot.controller.OwnerController
import org.mockito.junit.MockitoJUnitRunner

import org.junit.Assert
import org.mockito.MockitoAnnotations.initMocks
import javax.persistence.EntityNotFoundException

@RunWith(MockitoJUnitRunner::class)
class OwnerControllerTest: BaseController() {
    @InjectMocks
    lateinit var ownerController: OwnerController

    @Mock
    lateinit var ownerService: OwnerService

    private val ownerEntity = OwnerEntity(
        name = "1",
        gender = "male"
    )

    @Before
    fun init() {
        initMocks(this)
    }

    @Test
    fun shouldReturnOwnerResponse() {
        var ownerResponse = ownerEntity modelOf ""
        Mockito.`when`(ownerService.getRecord(1)).thenReturn(ownerResponse)

        var result = ownerController.getRecord(1)

        Assert.assertNotNull(result)
        Assert.assertEquals(result, getResponse(ownerResponse))
    }

    @Test(expected = EntityNotFoundException::class)
    fun shouldThrowException() {
        var recordId = 1L
        var ownerException = EntityNotFoundException("There is no entity exists with id $recordId !")

        Mockito.`when`(ownerService.getRecord(recordId)).thenThrow(ownerException)
        var result = ownerController.getRecord(1)
    }
}
