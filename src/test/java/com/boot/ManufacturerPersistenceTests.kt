package com.boot

import org.junit.Assert.assertEquals

import java.util.Date

import com.boot.repository.ManufacturerRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@ContextConfiguration(locations = arrayOf("classpath:com/guitar/db/applicationTests-context.xml"))
@RunWith(SpringJUnit4ClassRunner::class)
class ManufacturerPersistenceTests {
    @Autowired
    private val manufacturerRepository: ManufacturerRepository? = null

    @Test
    @Throws(Exception::class)
    fun testGetManufacturersFoundedBeforeDate() {
        val mans = manufacturerRepository!!.getManufacturersFoundedBeforeDate(Date())
        assertEquals(2, mans.size.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testGetManufactureByName() {
        val m = manufacturerRepository!!.getManufacturerByName("Fender")
        assertEquals("Fender Musical Instruments Corporation", m.name)
    }

    @Test
    @Throws(Exception::class)
    fun testGetManufacturersThatSellModelsOfType() {
        val mans = manufacturerRepository!!.getManufacturersThatSellModelsOfType("Semi-Hollow Body Electric")
        assertEquals(1, mans.size.toLong())
    }
}
