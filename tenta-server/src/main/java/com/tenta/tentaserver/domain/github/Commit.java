package com.tenta.tentaserver.domain.github;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Commit {

    private final String message;

    @Builder
    public Commit(String message) {
        this.message = message;
    }
}
