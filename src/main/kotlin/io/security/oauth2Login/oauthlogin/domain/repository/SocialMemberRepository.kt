package io.security.oauth2Login.oauthlogin.domain.repository

import io.security.oauth2Login.oauthlogin.domain.entity.SocialMember
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SocialMemberRepository: CrudRepository<SocialMember,Long> {
}