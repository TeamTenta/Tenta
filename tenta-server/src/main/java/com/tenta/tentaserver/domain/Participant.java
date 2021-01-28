package com.tenta.tentaserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Room_id")
    @JsonBackReference
    private Room room;

    @Builder
    public Participant(User user, Room room) {
        this.user = user;
        this.room = room;
    }

    public void setRoom(Room room) {
        this.room = room;

        if (!room.getParticipants().contains(this)) {
            room.getParticipants().add(this);
        }
    }
}
