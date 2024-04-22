package io.security.oauth2Login.oauthlogin.api.service

import com.example.oauth2loginsample.client.oauth2.kakao.dto.KakaoUserInfoResponse
import io.security.oauth2Login.oauthlogin.domain.entity.OAuth2Provider
import io.security.oauth2Login.oauthlogin.domain.entity.SocialMember
import io.security.oauth2Login.oauthlogin.domain.repository.SocialMemberRepository
import org.springframework.stereotype.Service

@Service
class SocialMemberService(
    private val socialMemberRepository: SocialMemberRepository
) {
    // 사용자 정보가 들어가 있음 = KakaoUserInfo
    // 만약에 없다면 만들어주고 있다면 조회해줘
    fun registerIfAbsent(userInfo: KakaoUserInfoResponse): SocialMember {
        return if (!socialMemberRepository.existsByProviderAndProviderId(OAuth2Provider.KAKAO, userInfo.id.toString())) {
            val socialMember = SocialMember.ofKakao(userInfo.id, userInfo.nickname)
            socialMemberRepository.save(socialMember)
        } else {
            socialMemberRepository.findByProviderAndProviderId(OAuth2Provider.KAKAO, userInfo.id.toString())
        }
    }
}