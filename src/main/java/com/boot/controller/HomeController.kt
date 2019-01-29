package com.boot.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @RequestMapping("/")
    fun home(): String {
        return "Das Boot, reporting for duty!"
    }
}
