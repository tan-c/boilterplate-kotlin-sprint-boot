package com.config

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity

@Configuration
@Order(101) // So that it will be after the AdminSecurityConfiguration
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity){
        http
            .csrf().disable()
            .authorizeRequests() // Put this at beginning will match all, see https://stackoverflow.com/questions/33603156/spring-security-multiple-http-config-not-working/33608459#33608459
            .antMatchers("/**/*").permitAll() // .antMatchers(*AUTH_WHITELIST).permitAll()
//            .antMatchers("/**/*").denyAll()
//            .anyRequest().authenticated().and().httpBasic()
//            .and().logout()
    }

    companion object {
        private val AUTH_WHITELIST = arrayOf(
            // -- swagger ui
            "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/api/v1/**", "/api/v1/owners/**"
        )
    }
}
