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
    // 여기에선 카카오가 올것이라고 정해져있기때문에 네이버나 구글로 확장 할 시 수정이 반드시 필요하다 <> 시큐리티 적용한 부분은 좀 더 유연한 편
    fun registerIfAbsent(userInfo: KakaoUserInfoResponse): SocialMember {
        return if (!socialMemberRepository.existsByProviderAndProviderId(OAuth2Provider.KAKAO, userInfo.id.toString())) {
            val socialMember = SocialMember.ofKakao(userInfo.id, userInfo.nickname)
            socialMemberRepository.save(socialMember)
        } else {
            socialMemberRepository.findByProviderAndProviderId(OAuth2Provider.KAKAO, userInfo.id.toString())
        }
    }
}