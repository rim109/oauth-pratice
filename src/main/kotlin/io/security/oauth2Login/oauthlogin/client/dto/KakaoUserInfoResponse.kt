package com.example.oauth2loginsample.client.oauth2.kakao.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class KakaoUserInfoResponse(
    val id: Long,
    val properties: KakaoUserPropertiesResponse
) {
    val nickname: String
        get() = properties.nickname
}