package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Actor {

    @JsonProperty("login")
    private String username;
    private String url;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    public Actor() {
    }

    @Builder
    public Actor(String username, String url, String avatarUrl) {
        this.username = username;
        this.url = url;
        this.avatarUrl = avatarUrl;
    }
}
