import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity

@Configuration
@Order(2) // So that it will be after the AdminSecurityConfiguration
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity){
        http
            .authorizeRequests()
            .antMatchers(*AUTH_WHITELIST).permitAll() // FIXME: this whitelist does not work, still showing basicLogin
//            .antMatchers("/**/*").denyAll()
            .anyRequest().authenticated().and().httpBasic()
            .and().logout()
    }

    companion object {
        private val AUTH_WHITELIST = arrayOf(
            // -- swagger ui
            "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**"
        )
    }
}
