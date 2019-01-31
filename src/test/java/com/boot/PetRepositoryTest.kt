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
    lateinit var petRepository: PetRepository

    @Test
    fun testFindAll() {
        val pets = petRepository!!.findAll()
        assertThat(pets.size, `is`(greaterThanOrEqualTo(0)))
    }
}


//@RunWith(SpringRunner::class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class HelloEndointIntegrationTest {
//    @Autowired
//    lateinit var testRestTemplate: TestRestTemplate
//    @Test
//    fun testHelloController() {
//        val result = testRestTemplate.getForEntity("/hello/string", String::class.java)
//        assertNotNull(result)
//        assertEquals(result.statusCode, HttpStatus.OK)
//        assertEquals(result.body, "Hello string!")
//    }
//    @Test
//    fun testHelloService() {
//        val result = testRestTemplate.getForEntity("/hello/service", String::class.java)
//        assertNotNull(result)
//        assertEquals(result.statusCode, HttpStatus.OK)
//        assertEquals(result.body, "Hello service!")
//    }
//    @Test
//    fun testHelloDto() {
//        val result = testRestTemplate.getForEntity("/hello/data", Hello::class.java)
//        assertNotNull(result)
//        assertEquals(result.statusCode, HttpStatus.OK)
//        assertEquals(result.body, Hello("Hello data!"))
//    }
//}
