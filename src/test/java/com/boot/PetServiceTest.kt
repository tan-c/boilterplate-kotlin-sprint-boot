package com.boot

import com.boot.model.PetEntity
import com.boot.model.PetRepository
import org.junit.Test
import org.mockito.Mock
import com.boot.service.PetService
import org.junit.Assert
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.Optional
import javax.persistence.EntityNotFoundException

//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner::class)
//@SpringBootTest(classes = [App::class])
@RunWith(MockitoJUnitRunner::class)
class PetServiceTest {
    @InjectMocks
    lateinit var petService: PetService

    @Mock
    lateinit var petRepository: PetRepository

    private val petEntity = PetEntity(
        name = "test name",
        gender = "male"
    )

    @Test
    fun testPetService() {
        var recordId = 1L
        Mockito.`when`(petRepository.findById(recordId)).thenReturn(Optional.of(petEntity))

        val testResult = petService.getRecord(recordId)
        var petResponse = petEntity modelOf ""
        Assert.assertEquals(petResponse, testResult)
    }

    @Test(expected = EntityNotFoundException::class)
    fun testPetServiceException() {
        var recordId = 1L
        var petException = EntityNotFoundException("There is no entity exists with id $recordId !")
        Mockito.`when`(petRepository.findById(recordId)).thenThrow(petException)

        val testResult = petService.getRecord(recordId)
    }
}
