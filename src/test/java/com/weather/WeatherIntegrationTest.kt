package com.weather

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.helper.FileLoader
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import java.util.Optional
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import java.util.HashMap

@RunWith(SpringRunner::class)
@SpringBootTest
class WeatherIntegrationTest {

    @Autowired
    private val subject: WeatherClient? = null

    @Rule @JvmField
    var wireMockRule = WireMockRule(8089)

    @Test
    @Throws(Exception::class)
    fun shouldCallWeatherService() {
        wireMockRule.stubFor(
            get(urlPathEqualTo("/some-test-api-key/53.5511,9.9937"))
                .willReturn(
                    aResponse()
                        .withBody(FileLoader.read("classpath:weatherApiResponse.json"))
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)
                )
        )

        val weatherResponse = subject!!.fetchWeather()

        val expectedResponse = "Rain"
        assertThat(((weatherResponse.get() as HashMap<Any, Any>).getValue("currently") as HashMap<Any, Any>).getValue("summary").toString(), `is`(expectedResponse))
    }
}
