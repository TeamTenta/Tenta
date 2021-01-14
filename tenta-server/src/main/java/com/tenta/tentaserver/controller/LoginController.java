package com.tenta.tentaserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/oauth/github/login")
    public RedirectView login(HttpServletRequest request) {
        /**
         * TODO - tentaApp 주소로 리디렉션
         * 지금은 localhost:8080/test로 리디렉션 중임.
         * query로 session Key값을 넘겨줌.
         */
        String sessionKey = request.getSession().getId();
        logger.info("LoginController session key : {}", sessionKey);

        Properties properties = new Properties();
        properties.put("sessionKey", sessionKey);

        RedirectView redirectView = new RedirectView("http://localhost:8080/test");
        redirectView.setAttributes(properties);
        return redirectView;
    }

    @GetMapping("/test")
    public String test(OAuth2AuthenticationToken token) {
        logger.info("{} access", token.getPrincipal().getAttributes().get("login"));
        return "test";
    }
}
