package com.boot

import com.boot.model.PetEntity
import com.boot.model.PetRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import org.hamcrest.Matchers.*
import org.hamcrest.core.IsNull
import org.junit.After
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ActiveProfiles("integration")
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [App::class])
@AutoConfigureMockMvc
class PetApiMockMVCIT {
    @Autowired
    lateinit var mvc: MockMvc

    @Autowired
    lateinit var petRepository: PetRepository

    private var petEntity = PetEntity(
        name = "new pet1",
        gender = "male",
        owner = null
    )

    @After
    @Throws(Exception::class)
    fun tearDown() {
        petRepository.deleteById(petEntity.id)
    }

    @Test
    @Throws(Exception::class)
    fun givenEmployees_whenGetEmployees_thenStatus200() {
        petRepository.save(petEntity)

        val urlTemplate = "/api/v1/pets/${petEntity.id}"
        mvc.perform(get(urlTemplate).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("data.name", `is`("new pet")))
            .andExpect(jsonPath("data.gender", `is`("male")))
            .andExpect(jsonPath("data.owner").value(IsNull.nullValue()))
    }
}


