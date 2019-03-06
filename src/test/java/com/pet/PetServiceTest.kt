package com.pet

import org.mockito.Mock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.Optional
import javax.persistence.EntityNotFoundException

@DisplayName("Given there is a pet")
class PetServiceTest {
    @InjectMocks
    lateinit var petService: PetService

    @Mock
    lateinit var petRepository: PetRepository

    private var petEntity: PetEntity? = null

    @BeforeEach
    fun init() {
        MockitoAnnotations.initMocks(this)
        petEntity = PetEntity(
            name = "1",
            gender = "male",
            owner = null
        )
    }

    @Nested
    @DisplayName("When you try to get the record") // Describe the context
    inner class PetSaved {

        @Test
        @DisplayName("You should be able to retrieve the user info given the id")
        fun testPetService() {
            var recordId = 1L
            Mockito.`when`(petRepository.findById(recordId)).thenReturn(Optional.of(petEntity!!))

            val testResult = petService.getRecord(recordId)
            var petResponse = petEntity!! modelOf ""
            Assertions.assertEquals(petResponse, testResult)
        }

        @Test
        @DisplayName("You should be getting an exception when you try to get a pet of an unknown id")
        fun testPetServiceException() {
            var recordId = 1L

            Assertions.assertThrows(EntityNotFoundException::class.java, {
                petService.getRecord(recordId)
            })
        }
    }
}
