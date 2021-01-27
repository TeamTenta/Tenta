package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PullRequest {

    @JsonProperty("html_url")
    private final String htmlUrl;
    private final String title;
    private final String body;

    @Builder
    public PullRequest(String htmlUrl, String title, String body) {
        this.htmlUrl = htmlUrl;
        this.title = title;
        this.body = body;
    }
}
