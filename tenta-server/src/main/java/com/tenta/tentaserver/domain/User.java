package com.tenta.tentaserver.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 40)
    private String username;

    @Column(length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 200)
    private String avatarUrl;

    @Column(nullable = false, length = 200)
    private String htmlUrl;

    @Column
    private int reposCount;

    @Column
    private int followersCount;

    @Column
    private int followingCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public User(String username,
                String name,
                String description,
                String avatarUrl,
                String htmlUrl,
                int reposCount,
                int followersCount,
                int followingCount,
                Role role,
                LocalDateTime createdAt,
                LocalDateTime updatedAt) {
        this.username = username;
        this.name = name;
        this.description = description;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
        this.reposCount = reposCount;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
