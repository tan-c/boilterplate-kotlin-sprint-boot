package com.boot

import com.boot.model.PetRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [App::class])
class ShipwreckRepositoryIntegrationTest {
    @Autowired
    private val petRepository: PetRepository? = null

    @Test
    fun testFindAll() {
        val pets = petRepository!!.findAll()
        assertThat(pets.size, `is`(greaterThanOrEqualTo(0)))
    }
}
