package com.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

//@EnableWebSecurity
@SpringBootApplication
open class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }

        @Bean
        fun restTemplate(): RestTemplate {
            return RestTemplateBuilder().build()
        }
    }
}
