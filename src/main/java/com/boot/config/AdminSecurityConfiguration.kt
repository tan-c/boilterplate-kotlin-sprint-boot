package com.boot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter

@Configuration
@Order(1)
// Default order is 100
open class AdminSecurityConfiguration : WebSecurityConfigurerAdapter() {
    private val digestAuthFilter: DigestAuthenticationFilter
        @Throws(Exception::class)
        get() {
            val digestFilter = DigestAuthenticationFilter()
            digestFilter.userDetailsService = userDetailsServiceBean()
            digestFilter.setAuthenticationEntryPoint(digestEntryPoint)
            return digestFilter
        }

    private val digestEntryPoint: DigestAuthenticationEntryPoint
        get() {
            val digestEntryPoint = DigestAuthenticationEntryPoint()
            digestEntryPoint.realmName = "admin-digest-realm"
            digestEntryPoint.key = "fjkf33DD312_+"
            return digestEntryPoint
        }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.headers().disable()
            .antMatcher("/api/v1/pets/**").addFilter(digestAuthFilter).exceptionHandling()
            .authenticationEntryPoint(digestEntryPoint)
            .and()
            .authorizeRequests()
            .antMatchers("/api/v1/pets/**").hasRole("ADMIN")
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.inMemoryAuthentication()
            .withUser("user").password("password").roles("USER")
            .and()
            .withUser("admin").password("password1").roles("ADMIN")
    }

    @Bean
    @Throws(Exception::class)
    override fun userDetailsServiceBean(): UserDetailsService {
        return super.userDetailsServiceBean()
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        // TODO: This is deprecated as NoOpPasswordEncoder is not suitable for PROD
        // For now it is fine.. as in https://app.pluralsight.com/player?course=spring-security-authentication-authorization-layers-of-defense&author=wojciech-lesniak&name=68ba7d48-af6c-4cd8-8c1e-ec903c61481e&clip=7&mode=live
        return NoOpPasswordEncoder.getInstance()
    }
}
