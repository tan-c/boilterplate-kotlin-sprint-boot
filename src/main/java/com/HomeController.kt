package com

import com.weather.WeatherClient
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@Api(value = "Homepage", tags = ["Homepage"], description = "Homepage Services")
@RequestMapping("")
class HomeController {
    @Autowired
    private lateinit var weatherClient: WeatherClient

    @ApiOperation(value = "Get homepage", notes = "")
    @GetMapping("/")
    fun home(): String {
        return "Das Boot, reporting for duty!"
    }

    @GetMapping("/weather")
    fun weather(): Optional<Any> {
        return weatherClient.fetchWeather()
    }
}
