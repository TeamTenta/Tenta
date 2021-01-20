package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Page {

    @JsonProperty("html_url")
    private final String htmlUrl;
    private final String title;
    private final String action;

    @Builder
    public Page(String htmlUrl, String title, String action) {
        this.htmlUrl = htmlUrl;
        this.title = title;
        this.action = action;
    }
}
