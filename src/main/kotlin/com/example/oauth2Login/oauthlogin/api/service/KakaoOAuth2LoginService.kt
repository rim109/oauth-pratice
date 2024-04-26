package com.example.oauth2Login.oauthlogin.api.service

import com.example.oauth2Login.oauthlogin.client.KakaoOAuth2Client
import com.example.oauth2Login.oauthlogin.common.JwtHelper
import org.springframework.stereotype.Service

@Service
class KakaoOAuth2LoginService(
    private val kakaoOAuth2Client: KakaoOAuth2Client,
    private val socialMemberService: SocialMemberService,
    private val jwtHelper: JwtHelper
) {
    fun login(authorizationCode: String): String {
        //1. 인가코드 -> 엑세스 토큰 발급
        val accessToken: String = kakaoOAuth2Client.getAccessToken(authorizationCode)
        //2. 액세스 토큰으로 사용자 정보 조회
        val userInfo = kakaoOAuth2Client.retrieveUserInfo(accessToken)
        //3. 사용자 정보로 SocialMember 있으면 조회, 없으면 회원가입
        val socialMember = socialMemberService.registerIfAbsent(userInfo)
        //4. SocialMember 를 토대로 우리쪽 액세스 토큰 발급 후 응답
        return jwtHelper.generateAccessToken(socialMember.id!!)

        //이를 let 확장함수를 사용하면 비교적 더 가독성 있게 볼 수 있음
        //fun login(authorizationCode: String): String {
        //        return kakaoOAuth2Client.getAccessToken(authorizationCode)
        //            .let { kakaoOAuth2Client.retrieveUserInfo(it) }
        //            .let { socialMemberService.registerIfAbsent(it) }
        //            .let { jwtHelper.generateAccessToken(it.id!!) }
        //    }
    }
}