package com.boot

import com.boot.model.OwnerEntity
import com.boot.model.OwnerRepository
import com.boot.service.OwnerService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.Optional
import javax.persistence.EntityNotFoundException

@RunWith(MockitoJUnitRunner::class)
class OwnerServiceTest {
    @InjectMocks
    lateinit var ownerService: OwnerService

    @Mock
    lateinit var ownerRepository: OwnerRepository

    private val ownerEntity = OwnerEntity(
        name = "test name",
        gender = "male",
        email = "testowner1@gmail.com"
    )

    @Test
    fun testOwnerService() {
        var recordId = 1L
        Mockito.`when`(ownerRepository.findById(recordId)).thenReturn(Optional.of(ownerEntity))

        val testResult = ownerService.getRecord(recordId)
        var ownerResponse = ownerEntity modelOf ""
        Assert.assertEquals(ownerResponse, testResult)
    }

    @Test(expected = EntityNotFoundException::class)
    fun testOwnerServiceException() {
        var recordId = 1L
        var ownerException = EntityNotFoundException("There is no entity exists with id $recordId !")
        Mockito.`when`(ownerRepository.findById(recordId)).thenThrow(ownerException)

        val testResult = ownerService.getRecord(recordId)
    }
}
