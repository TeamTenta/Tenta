package com.tenta.tentaserver.domain.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WatchEvent implements Payload {

    private final String action;

    @Builder
    public WatchEvent(String action) {
        this.action = action;
    }
}
