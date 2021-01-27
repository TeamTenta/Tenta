package com.tenta.tentaserver.domain;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class RoomDTO implements Serializable {

    private final long id;
    private List<Participant> participants;
    private LocalDateTime createAt;
    private LocalDateTime lastMessageTime;

    @Builder
    public RoomDTO(long id, List<Participant> participants, LocalDateTime createAt, LocalDateTime lastMessageTime) {
        this.id = id;
        this.participants = participants;
        this.createAt = createAt;
        this.lastMessageTime = lastMessageTime;
    }
}
