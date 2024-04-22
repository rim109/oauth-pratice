package io.security.oauth2Login.oauthlogin.domain.repository

import io.security.oauth2Login.oauthlogin.domain.entity.OAuth2Provider
import io.security.oauth2Login.oauthlogin.domain.entity.SocialMember
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SocialMemberRepository: CrudRepository<SocialMember,Long> {
    fun existsByProviderAndProviderId(kakao: OAuth2Provider, toString: String): Boolean

    fun findByProviderAndProviderId(kakao: OAuth2Provider, toString: String): SocialMember
}