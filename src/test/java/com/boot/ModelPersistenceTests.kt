package com.boot

import org.junit.Assert.assertEquals

import java.math.BigDecimal
import java.util.Date

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

import com.boot.repository.ModelRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional

import com.boot.model.Model

@ContextConfiguration(locations = arrayOf("classpath:com/guitar/db/applicationTests-context.xml"))
@RunWith(SpringJUnit4ClassRunner::class)
class ModelPersistenceTests {
    @Autowired
    private val modelRepository: ModelRepository? = null

    @PersistenceContext
    private val entityManager: EntityManager? = null

    @Test
    @Transactional
    @Throws(Exception::class)
    fun testSaveAndGetAndDelete() {
        var m = Model()
        m.frets = 10
        m.name = "Test Model"
        m.price = BigDecimal.valueOf(55L)
        m.woodType = "Maple"
        m.yearFirstMade = Date()
        m = modelRepository!!.create(m)

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager!!.clear()

        val otherModel = modelRepository.find(m.id)
        assertEquals("Test Model", otherModel.name)
        assertEquals(10, otherModel.frets.toLong())

        //delete BC location now
        modelRepository.delete(otherModel)
    }

    @Test
    @Throws(Exception::class)
    fun testGetModelsInPriceRange() {
        val mods = modelRepository!!.getModelsInPriceRange(BigDecimal.valueOf(1000L), BigDecimal.valueOf(2000L))
        assertEquals(4, mods.size.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testGetModelsByPriceRangeAndWoodType() {
        val mods = modelRepository!!.getModelsByPriceRangeAndWoodType(
            BigDecimal.valueOf(1000L),
            BigDecimal.valueOf(2000L),
            "Maple"
        )
        assertEquals(3, mods.size.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testGetModelsByType() {
        val mods = modelRepository!!.getModelsByType("Electric")
        assertEquals(4, mods.size.toLong())
    }
}
