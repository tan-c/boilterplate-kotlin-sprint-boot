package com.boot.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import java.util.HashMap
import java.util.Optional

@Component
class WeatherClient @Autowired
constructor(
    private val restTemplate: RestTemplate,
    @param:Value("\${weather.url}") private val weatherServiceUrl: String,
    @param:Value("\${weather.api_secret}") private val weatherServiceApiKey: String
) {

    fun fetchWeather(): Optional<Any> {
        val url = String.format("%s/%s/%s,%s", weatherServiceUrl, weatherServiceApiKey, LATITUDE, LONGITUDE)

        try {
            return Optional.ofNullable(restTemplate.getForObject(url, HashMap::class.java))
        } catch (e: RestClientException) {
            return Optional.empty()
        }
    }

    companion object {

        private val LATITUDE = "53.5511"
        private val LONGITUDE = "9.9937"
    }
}
