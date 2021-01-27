package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.Issue;
import lombok.Builder;
import lombok.Getter;

@Getter
public class IssuesEvent implements Payload {

    private final String action;
    private final Issue issue;

    @Builder
    public IssuesEvent(String action, Issue issue) {
        this.action = action;
        this.issue = issue;
    }
}
