package com.boot

import com.boot.model.OwnerEntity
import com.boot.model.OwnerRepository
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
class OwnerRepositoryIT {
    @Autowired
    lateinit var ownerRepository: OwnerRepository

    private var ownerEntity = OwnerEntity(
        name = "new owner",
        gender = "male"
    )

    @After
    @Throws(Exception::class)
    fun tearDown() {
        ownerRepository.deleteById(ownerEntity.id)
    }

    @Test
    fun testCreatingOwnerRecord() {
        ownerRepository.save(ownerEntity)
        val maybeNewlyCreatedOwner = ownerRepository.findById(ownerEntity.id)
        assertThat(maybeNewlyCreatedOwner!!.get().id, `is`(Optional.of(ownerEntity).get().id))
    }
}
