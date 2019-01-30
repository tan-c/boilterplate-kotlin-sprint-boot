package com.config

import com.boot.service.PetService
import org.mockito.Mockito
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile

@Profile("test")
@Configuration
open class PetServiceTestConfiguration {
    @Bean
    @Primary
    open fun petService(): PetService {
        return Mockito.mock(PetService::class.java)
    }
}
