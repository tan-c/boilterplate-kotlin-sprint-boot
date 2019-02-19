//package com.pluralsight.security.configuration
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//
//@Configuration
//open class SecurityConfig : WebSecurityConfigurerAdapter() {
//
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http
//            .authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic()
//    }
//}

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
@Configuration
internal open class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(web: WebSecurity?) {
        web!!.ignoring().antMatchers(
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/**",
            "/swagger-ui.html",
            "/webjars/**"
        )

        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
    }

//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http.authorizeRequests()
//            .antMatchers(*AUTH_WHITELIST).permitAll()
//            .antMatchers("/**/*").denyAll()
//    }
//
//    companion object {
//        private val AUTH_WHITELIST = arrayOf(
//            // -- swagger ui
//            "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**"
//        )
//    }
}
