package com.boot

import org.junit.Test
import org.junit.Assert.assertEquals

import com.boot.controller.HomeController

class HomeControllerTest {

    @Test
    fun testHomeController() {
        val hc = HomeController()
        val result = hc.home()
        assertEquals(result, "Das Boot, reporting for duty!")
    }
}
