package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.Commit;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PushEvent implements Payload {

    private final List<Commit> commits;

    @Builder
    public PushEvent(List<Commit> commits) {
        this.commits = commits;
    }
}
