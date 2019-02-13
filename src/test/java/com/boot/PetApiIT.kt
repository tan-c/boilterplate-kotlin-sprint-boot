package com.boot

import java.io.IOException

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import java.util.HashMap

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [App::class])
class PetApiIT {
    @Test
    @Throws(IOException::class)
    fun testListAllPets() {
        val testRestTemplate = TestRestTemplate()
        // FIXME: Using ApiResponse instead of HashMap to marshall the output

        // FIXME: you should not be using the absoluate URI, using a var to represent the first part
        val responseEntity = testRestTemplate.getForEntity("http://localhost:8088/api/v1/pets", HashMap::class.java)

        val objects = responseEntity.body
        val contentType = responseEntity.headers.contentType
        val statusCode = responseEntity.statusCode
        assertThat(statusCode, equalTo(HttpStatus.OK))
        assertThat(objects.get("data"), notNullValue())
        assertThat(objects.get("error"), notNullValue())
    }
}
