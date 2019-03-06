package com.owner

import com.App
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

    @After
    @Throws(Exception::class)
    fun tearDown() {
        ownerRepository.deleteAll()
    }

    @Test
    fun testCreatingOwnerRecord() {
        var ownerEntity = OwnerEntity(
            name = "new owner",
            gender = "male"
        )
        ownerRepository.save(ownerEntity)
        val maybeNewlyCreatedOwner = ownerRepository.findById(ownerEntity.id)
        assertThat(maybeNewlyCreatedOwner!!.get().id, `is`(Optional.of(ownerEntity).get().id))
    }
}
