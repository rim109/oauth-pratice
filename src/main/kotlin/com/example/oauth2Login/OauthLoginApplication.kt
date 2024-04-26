package com.example.oauth2Login

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OauthLoginApplication

fun main(args: Array<String>) {
	runApplication<OauthLoginApplication>(*args)
}
