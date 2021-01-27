package com.tenta.tentaserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/oauth/github/login")
    public RedirectView login(HttpServletRequest request) {
        String sessionKey = request.getSession().getId();
        logger.info("[LoginController] session key : {}", sessionKey);

        return new RedirectView("tenta://" + sessionKey);
    }
}
