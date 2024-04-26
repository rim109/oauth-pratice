package com.example.oauth2Login.oauthlogin.domain.entity

import jakarta.persistence.*

// 회원가입을 시키고 싶은 것, 오어스 멤버 로그인 성공시 정보를 저장하기 위한 엔티티
@Entity
class SocialMember(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "social_member_id")
    var id: Long? = null,

    @Enumerated(EnumType.STRING)
    val provider: OAuth2Provider,
    val providerId: String,
    // 고유식별자, 우연의 일치로 구글과 네이버가 동등할 경우를 대비하여 이넘클래스를 만들어 구분함.
    val nickname: String
) {
    companion object {
        fun ofKakao(id: Long, nickname: String): SocialMember {
            return SocialMember(
                provider = OAuth2Provider.KAKAO,
                providerId = id.toString(),
                nickname = nickname
            )
        }
    }
}

enum class OAuth2Provider {
    KAKAO
}