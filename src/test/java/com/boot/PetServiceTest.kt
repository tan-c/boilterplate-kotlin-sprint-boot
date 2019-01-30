package com.boot

import org.junit.Test
import org.mockito.Mock
import com.boot.model.PetResponseModel
import com.boot.service.PetService
import org.junit.Assert
import org.junit.runner.RunWith
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
    fun testPetService() {
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
