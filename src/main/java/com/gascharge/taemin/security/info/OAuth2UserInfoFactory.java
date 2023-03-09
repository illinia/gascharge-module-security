package com.gascharge.taemin.security.info;

import com.gascharge.taemin.common.oauth.AuthProvider;
import com.gascharge.taemin.security.exception.OAuth2AuthenticationProcessingException;
import com.gascharge.taemin.security.info.impl.GoogleOAuth2UserInfo;
import com.gascharge.taemin.security.info.impl.KakaoOAuth2UserInfo;
import com.gascharge.taemin.security.info.impl.NaverOAuth2UserInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        log.info("getOAuth2UserInfo() registrationId = {}", registrationId);
        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.naver.toString())) {
            return new NaverOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.kakao.toString())) {
            return new KakaoOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Login with " + registrationId + " is not supported yet.");
        }
    }
}
