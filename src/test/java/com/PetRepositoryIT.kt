package com

import com.App
import com.model.OwnerEntity
import com.model.OwnerRepository
import com.model.PetEntity
import com.model.PetRepository
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

    @Autowired
    lateinit var ownerRepository: OwnerRepository

    private var ownerEntity = OwnerEntity(
        name = "new owner",
        gender = "male",
        email = "newowner@gmail.com"
    )

    private var petEntity = PetEntity(
        name = "new pet",
        gender = "male",
        owner = ownerEntity
    )

    @After
    @Throws(Exception::class)
    fun tearDown() {
//        petRepository.deleteById(petEntity.id)
        // Need to delete owner manually as petEntity does not cascade delete owner
        // Note tgat deleting owner will delete the pets associated automatically
        ownerRepository.deleteById(ownerEntity.id)
    }

    @Test
    fun testCreatingPetRecord() {
        petRepository.save(petEntity)
        val maybeNewlyCreatedPet = petRepository.findById(petEntity.id)
        assertThat(maybeNewlyCreatedPet!!.get().id, `is`(Optional.of(petEntity).get().id))
        assertThat(maybeNewlyCreatedPet!!.get().owner?.id, `is`(Optional.of(petEntity).get().owner?.id))
    }
}
