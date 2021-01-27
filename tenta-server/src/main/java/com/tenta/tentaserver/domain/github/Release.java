package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Release {

    @JsonProperty("html_url")
    private final String htmlUrl;
    private final String name;

    @Builder
    public Release(String htmlUrl, String name) {
        this.htmlUrl = htmlUrl;
        this.name = name;
    }
}
