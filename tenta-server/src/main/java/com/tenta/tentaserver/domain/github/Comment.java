package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Comment {

    @JsonProperty("html_url")
    private final String htmlUrl;
    private final String body;

    @Builder
    public Comment(String htmlUrl, String body) {
        this.htmlUrl = htmlUrl;
        this.body = body;
    }
}
