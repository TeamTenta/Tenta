package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {

    public long id;
    public String login;
    public String url;

    @JsonProperty("avatar_url")
    public String avatarUrl;
}
