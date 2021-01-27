package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenta.tentaserver.domain.FeedDTO;
import com.tenta.tentaserver.domain.FeedType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Getter
public class Event {

    private String type;
    private Actor actor;
    private Repository repo;
    private Map<String, Object> payload;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    public FeedDTO toFeedDTO() {
        FeedType feedType = FeedType.getFeedType(type);
        Objects.requireNonNull(feedType);

        return FeedDTO.builder()
                .type(feedType.getValue())
                .actor(actor)
                .repo(repo)
                .payload(payload)
                .createdAt(createdAt)
                .build();
    }
}
