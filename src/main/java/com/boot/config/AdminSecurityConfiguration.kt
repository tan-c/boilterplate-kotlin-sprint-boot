package com.boot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter

@Configuration
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
        http.headers().disable().antMatcher("/support/admin/**").addFilter(digestAuthFilter).exceptionHandling()
            .authenticationEntryPoint(digestEntryPoint)
            .and().authorizeRequests().antMatchers("/support/admin/**").hasRole("ADMIN")
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
        return NoOpPasswordEncoder.getInstance()
    }
}
