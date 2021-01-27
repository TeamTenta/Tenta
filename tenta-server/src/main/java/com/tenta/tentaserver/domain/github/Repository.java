package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Repository {

    @JsonProperty("name")
    private String fullName;
    private String url;

    public Repository() {
    }

    @Builder
    public Repository(String fullName, String url) {
        this.fullName = fullName;
        this.url = url;
    }
}
