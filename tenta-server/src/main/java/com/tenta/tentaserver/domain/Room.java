package com.tenta.tentaserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoomStatus status = RoomStatus.OPENED;

    @OneToMany(mappedBy = "room")
    private List<Participant> participants = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    public void addParticipants(Participant participant) {
        this.participants.add(participant);

        if (participant.getRoom() != this) {
            participant.setRoom(this);
        }
    }
}
