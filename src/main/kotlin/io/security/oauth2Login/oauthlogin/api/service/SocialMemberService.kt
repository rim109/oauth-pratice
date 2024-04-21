package io.security.oauth2Login.oauthlogin.api.service

import io.security.oauth2Login.oauthlogin.domain.entity.SocialMember
import io.security.oauth2Login.oauthlogin.domain.repository.SocialMemberRepository
import org.springframework.stereotype.Service

@Service
class SocialMemberService(
    private val socialMemberRepository: SocialMemberRepository
) {
    fun registerIfAbsent(userInfo: Any) {
        return ///
    }
}