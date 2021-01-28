package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.PullRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PullRequestEvent implements Payload {

    private final String action;
    private final PullRequest pullRequest;

    @Builder
    public PullRequestEvent(String action, PullRequest pullRequest) {
        this.action = action;
        this.pullRequest = pullRequest;
    }
}
