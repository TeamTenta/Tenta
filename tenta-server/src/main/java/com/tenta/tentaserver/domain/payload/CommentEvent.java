package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentEvent implements Payload {

    private final String action;
    private final Comment comment;

    @Builder
    public CommentEvent(String action, Comment comment) {
        this.action = action;
        this.comment = comment;
    }
}
