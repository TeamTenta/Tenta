package com.tenta.tentaserver.domain.dto;

import com.tenta.tentaserver.domain.Participant;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ParticipantDTO implements Serializable {

    private UserDTO user;

    @Builder
    public ParticipantDTO(UserDTO user) {
        this.user = user;
    }

    public static ParticipantDTO toParticipantDTO(Participant participant) {
        return ParticipantDTO.builder()
                .user(UserDTO.toUserDTO(participant.getUser()))
                .build();
    }
}
