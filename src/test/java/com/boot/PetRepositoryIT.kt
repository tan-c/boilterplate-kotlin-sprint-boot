package com.boot

import com.boot.model.PetEntity
import com.boot.model.PetRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.After
import java.util.Optional

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [App::class])
class PetRepositoryIT {
    @Autowired
    lateinit var petRepository: PetRepository

    private var petEntity = PetEntity(
        name = "new pet",
        gender = "male"
    )

    @After
    @Throws(Exception::class)
    fun tearDown() {
        petRepository.deleteById(petEntity.id)
    }

    @Test
    fun testCreatingPetRecord() {
        petRepository.save(petEntity)
        val maybeNewlyCreatedPet = petRepository.findById(petEntity.id)
        assertThat(maybeNewlyCreatedPet, `is`(Optional.of(petEntity)))
    }
}
