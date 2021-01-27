package com.tenta.tentaserver.service;

import com.tenta.tentaserver.domain.OAuthUser;
import com.tenta.tentaserver.domain.User;
import com.tenta.tentaserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private static final Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        String tokenValue = userRequest.getAccessToken().getTokenValue();
        logger.info("Access Token : {}", tokenValue);

        OAuthUser oAuthUser = OAuthUser.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        User user = saveOrUpdate(oAuthUser);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                oAuthUser.getAttributes(),
                oAuthUser.getNameAttributeKey());
    }

    private User saveOrUpdate(OAuthUser oAuthUser) {
        User user = userRepository.findByUsername((String) oAuthUser.getAttributes().get("login"))
                .orElse(oAuthUser.toEntity());

        return userRepository.save(user);
    }
}
