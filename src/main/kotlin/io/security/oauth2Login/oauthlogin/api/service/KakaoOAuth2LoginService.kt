package io.security.oauth2Login.oauthlogin.api.service

import io.security.oauth2Login.oauthlogin.client.KakaoOAuth2Client
import io.security.oauth2Login.oauthlogin.common.JwtHelper
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
    }
}