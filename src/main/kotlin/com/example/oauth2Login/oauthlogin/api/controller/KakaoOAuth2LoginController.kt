package com.example.oauth2Login.oauthlogin.api.controller

import com.example.oauth2Login.oauthlogin.api.service.KakaoOAuth2LoginService
import com.example.oauth2Login.oauthlogin.client.KakaoOAuth2Client
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class KakaoOAuth2LoginController(
    private val kakaoOAuth2LoginService: KakaoOAuth2LoginService,
    private val kakaoOAuth2Client: KakaoOAuth2Client
) {
    // 로그인 페이지로 Redirect 해주는 API
    @GetMapping("/oauth2/login/kakao")
    fun redirectLoginPage(res: HttpServletResponse){
        val loginPageUrl = kakaoOAuth2Client.generateLoginPageUrl()
        res.sendRedirect(loginPageUrl)
    }


    // AuthorizationCode를 이용해 사용자 인증을 처리해주는 API
    @GetMapping("/oauth2/callback/kakao")
    fun callback(@RequestParam(name = "code") authorizationCode: String): String {
        return kakaoOAuth2LoginService.login(authorizationCode)
    }
}