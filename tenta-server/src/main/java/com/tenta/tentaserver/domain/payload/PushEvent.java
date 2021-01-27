package com.tenta.tentaserver.domain.payload;

import com.tenta.tentaserver.domain.github.Commit;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PushEvent implements Payload {

    private final String ref;
    private final List<Commit> commits;

    @Builder
    public PushEvent(String ref, List<Commit> commits) {
        this.ref = ref;
        this.commits = commits;
    }
}
