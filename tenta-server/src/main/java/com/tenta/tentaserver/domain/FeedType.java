package com.tenta.tentaserver.domain;

import lombok.Getter;

@Getter
public enum FeedType {
    COMMIT_COMMENT_EVENT("CommitCommentEvent"),
    CREATE_EVENT("CreateEvent"), // repo, tag, branch
    DELETE_EVENT("DeleteEvent"),
    FORK_EVENT("ForkEvent"),
    PUBLIC_EVENT("PublicEvent"),
    GOLLUM_EVENT("GollumEvent"),
    ISSUE_COMMENT_EVENT("IssueCommentEvent"),
    ISSUES_EVENT("IssuesEvent"),
    MEMBER_EVENT("MemberEvent"),
    PULL_REQUEST_EVENT("PullRequestEvent"),
    PULL_REQUEST_REVIEW_COMMENT_EVENT("PullRequestReviewCommentEvent"),
    PUSH_EVENT("PushEvent"),
    RELEASE_EVENT("ReleaseEvent"),
    SPONSORSHIP_EVENT("SponsorshipEvent"),
    WATCH_EVENT("WatchEvent");

    private final String value;

    FeedType(String value) {
        this.value = value;
    }

    public static FeedType getFeedType(String type) {
        for (FeedType feedType : values()) {
            if (feedType.value.equals(type)) {
                return feedType;
            }
        }
        return null;
    }
}
