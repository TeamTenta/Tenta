package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.Actor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberEvent implements Payload {

    private final String action;
    private final Actor member;

    @Builder
    public MemberEvent(String action, Actor member) {
        this.action = action;
        this.member = member;
    }
}
