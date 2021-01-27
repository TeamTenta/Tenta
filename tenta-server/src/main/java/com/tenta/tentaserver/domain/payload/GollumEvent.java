package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.Page;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class GollumEvent implements Payload {

    private final List<Page> pages;

    @Builder
    public GollumEvent(List<Page> pages) {
        this.pages = pages;
    }
}
