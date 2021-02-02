package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Actor {

    @JsonProperty("login")
    private String username;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    public Actor() {
    }

    @Builder
    public Actor(String username, String htmlUrl, String avatarUrl) {
        this.username = username;
        this.htmlUrl = htmlUrl;
        this.avatarUrl = avatarUrl;
    }
}
