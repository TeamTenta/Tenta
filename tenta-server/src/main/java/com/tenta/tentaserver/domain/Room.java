package com.tenta.tentaserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoomStatus status = RoomStatus.OPENED;

    @OneToMany
    private List<Participant> participants;

    @CreatedDate
    private LocalDateTime createAt;
}
