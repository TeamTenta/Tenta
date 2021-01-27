package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.Release;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ReleaseEvent implements Payload {

    private final String action;
    private final Release release;

    @Builder
    public ReleaseEvent(String action, Release release) {
        this.action = action;
        this.release = release;
    }
}
