package io.security.oauth2Login.oauthlogin.domain.repository

import io.security.oauth2Login.oauthlogin.domain.entity.OAuth2Provider
import io.security.oauth2Login.oauthlogin.domain.entity.SocialMember
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
//CrudRepository는 CRUD기능을 주로 제공하는 repository로 JPA는 CrudRepository와 PagingAndSortingRepository의 기능들을 모두 가진다.
interface SocialMemberRepository: CrudRepository<SocialMember,Long> {
    fun existsByProviderAndProviderId(kakao: OAuth2Provider, toString: String): Boolean

    fun findByProviderAndProviderId(kakao: OAuth2Provider, toString: String): SocialMember
}