package com.boot.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = "Homepage", tags = ["Homepage"], description = "Homepage Services")
@RequestMapping("")
class HomeController {
    @ApiOperation(value = "Get homepage", notes = "")
    @GetMapping("/")
    fun home(): String {
        return "Das Boot, reporting for duty!"
    }
}
