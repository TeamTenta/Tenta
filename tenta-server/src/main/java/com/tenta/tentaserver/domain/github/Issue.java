package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Issue {

    @JsonProperty("html_url")
    private final String htmlUrl;
    private final String title;

    @Builder
    public Issue(String htmlUrl, String title) {
        this.htmlUrl = htmlUrl;
        this.title = title;
    }
}
