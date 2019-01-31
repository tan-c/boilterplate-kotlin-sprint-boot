package com.boot

import java.io.IOException

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.fasterxml.jackson.databind.ObjectMapper

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [App::class])
class PetControllerIntegrationTest {
    @Test
    @Throws(IOException::class)
    fun testListAllPets() {
        val testRestTemplate = TestRestTemplate()
        val response = testRestTemplate.getForEntity("http://localhost:8088/api/v1/pets", String::class.java)

        assertThat(response.statusCode, equalTo(HttpStatus.OK))

        val objectMapper = ObjectMapper()
        val responseJson = objectMapper.readTree(response.body)

        assertThat(responseJson.isMissingNode, `is`(false))
        //	    assertThat( responseJson.toString() , not(null) );
    }
}
