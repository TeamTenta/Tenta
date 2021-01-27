package com.tenta.tentaserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenta.tentaserver.domain.github.*;
import com.tenta.tentaserver.domain.payload.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.tenta.tentaserver.domain.FeedType.getFeedType;

@Getter
public class FeedDTO {

    private final String type;
    private final Actor actor;
    private final Repository repo;
    private final Payload payload;

    @JsonProperty("created_at")
    private final LocalDateTime createdAt;

    @Builder
    public FeedDTO(String type, Actor actor, Repository repo, Map<String, Object> payload, LocalDateTime createdAt) {
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.payload = convert(type, payload);
        this.createdAt = createdAt;
    }

    private Payload convert(String type, Map<String, Object> payload) {
        FeedType feedType = getFeedType(type);
        Objects.requireNonNull(feedType);

        switch (feedType) {
            case COMMIT_COMMENT_EVENT:
            case ISSUE_COMMENT_EVENT:
            case PULL_REQUEST_REVIEW_COMMENT_EVENT:
                String action = (String) payload.getOrDefault("action", null);
                Map comment = (Map) payload.get("comment");
                return CommentEvent.builder()
                        .action(action)
                        .comment(Comment.builder()
                                .htmlUrl((String) comment.get("html_url"))
                                .body((String) comment.get("body"))
                                .build())
                        .build();
            case CREATE_EVENT:
            case DELETE_EVENT:
                return ReferenceType.builder()
                        .refType((String) payload.get("ref_type"))
                        .build();
            case GOLLUM_EVENT:
                List<Page> pages = new ArrayList<>();
                for (Object page : ((List) payload.get("pages"))) {
                    pages.add(Page.builder()
                            .htmlUrl((String) ((Map) page).get("html_url"))
                            .title((String) ((Map) page).get("title"))
                            .action((String) ((Map) page).get("action"))
                            .build());
                }
                return GollumEvent.builder()
                        .pages(pages)
                        .build();
            case ISSUES_EVENT:
                Map issue = (Map) payload.get("issue");
                return IssuesEvent.builder()
                        .action((String) payload.get("action"))
                        .issue(Issue.builder()
                                .htmlUrl((String) issue.get("html_url"))
                                .title((String) issue.get("title"))
                                .build())
                        .build();
            case MEMBER_EVENT:
                Map member = (Map) payload.get("issue");
                return MemberEvent.builder()
                        .action((String) payload.get("action"))
                        .member(Actor.builder()
                                .username((String) member.get("login"))
                                .url((String) member.get("url"))
                                .avatarUrl((String) member.get("avatar_url"))
                                .build())
                        .build();
            case PULL_REQUEST_EVENT:
                Map pullRequest = (Map) payload.get("pull_request");
                return PullRequestEvent.builder()
                        .action((String) payload.get("action"))
                        .pullRequest(PullRequest.builder()
                                .htmlUrl((String) pullRequest.get("html_url"))
                                .title((String) pullRequest.get("title"))
                                .body((String) pullRequest.get("body"))
                                .build())
                        .build();
            case PUSH_EVENT:
                List<Commit> commits = new ArrayList<>();
                for (Object commit : ((List) payload.get("commits"))) {
                    commits.add(Commit.builder()
                            .message((String) ((Map) commit).get("message"))
                            .build());
                }
                return PushEvent.builder()
                        .ref((String) payload.get("ref"))
                        .commits(commits)
                        .build();
            case RELEASE_EVENT:
                Map release = (Map) payload.get("release");
                return ReleaseEvent.builder()
                        .action((String) payload.get("action"))
                        .release(Release.builder()
                                .htmlUrl((String) release.get("html_url"))
                                .name((String) release.get("name"))
                                .build())
                        .build();
            case SPONSORSHIP_EVENT:
                return SponsorshipEvent.builder()
                        .action((String) payload.get("action"))
                        .effectiveDate((String) payload.get("effective_date"))
                        .build();
            case WATCH_EVENT:
                return WatchEvent.builder()
                        .action((String) payload.get("action"))
                        .build();
            default:
                return null;
        }
    }
}
