package com.tenta.tentaserver.domain.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PullRequestEvent implements Payload {

    @JsonProperty("html_url")
    private final String htmlURL;
    private final String title;
    private final String body;

    @Builder
    public PullRequestEvent(String htmlURL, String title, String body) {
        this.htmlURL = htmlURL;
        this.title = title;
        this.body = body;
    }
}
