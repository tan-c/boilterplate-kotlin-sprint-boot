package com

import com.model.OwnerEntity
import com.model.OwnerRepository
import com.service.OwnerService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.Optional
import javax.persistence.EntityNotFoundException

@DisplayName("Given there is an owner")
class OwnerControllerTest {
    @InjectMocks
    lateinit var ownerService: OwnerService

    @Mock
    lateinit var ownerRepository: OwnerRepository

    private var ownerEntity: OwnerEntity? = null

    @BeforeEach
    fun init() {
        MockitoAnnotations.initMocks(this)
        ownerEntity = OwnerEntity(
            name = "test name",
            gender = "male",
            email = "testowner1@gmail.com"
        )
    }

    @Nested
    @DisplayName("When you try to get the record") // Describe the context
    inner class UserSaved {
        @Test
        @DisplayName("You should be able to retrieve the user info given the id")
        fun should_return_owner_response_with_saved_user_id() {
            var recordId = 1L
            Mockito.`when`(ownerRepository.findById(recordId)).thenReturn(Optional.of(ownerEntity!!))

            val testResult = ownerService.getRecord(recordId)
            var ownerResponse = ownerEntity!! modelOf ""
            Assertions.assertEquals(ownerResponse, testResult)
        }

        @Test()
        @DisplayName("You should be getting an exception when you try to get an user of an unknown id")
        fun should_throw_exception_with_unsaved_user_id() {
            var recordId = 1L
//            var ownerException = EntityNotFoundException("There is no entity exists with id $recordId !")
//            Mockito.`when`(ownerRepository.findById(recordId)).thenThrow(ownerException)

            Assertions.assertThrows(EntityNotFoundException::class.java, {
                ownerService.getRecord(recordId)
            })
        }
    }
}
