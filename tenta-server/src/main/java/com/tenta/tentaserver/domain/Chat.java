package com.tenta.tentaserver.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "Room_id")
    private Room room;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createAt;

    @Builder
    public Chat(long id, String content, User sender, Room room, LocalDateTime createAt) {
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.room = room;
        this.createAt = createAt;
    }
}
