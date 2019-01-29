package com.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer


//object App {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        SpringApplication.run(App::class.java, *args)
//        //        SpringApplication.run(SteyServiceApplication::class.java, *args)
//    }
//}


@SpringBootApplication
//@EnableResourceServer
open class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}
