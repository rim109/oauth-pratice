package io.security.oauth2Login.oauthlogin.client

import org.springframework.stereotype.Component

@Component
class KakaoOAuth2Client {
    fun generateLoginPageUrl(): String? {
        return ""
    }

    fun getAccessToken(authorizationCode: String): String {
        return ""
    }

    fun retrieveUserInfo(accessToken: String): Any {
        return ""
    }
}