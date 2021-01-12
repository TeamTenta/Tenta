package com.tenta.tentaserver.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String username;

    @Column(length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 200)
    private String avatarUrl;

    @Column(nullable = false, length = 200)
    private String url;

    @Column
    private int reposCount;

    @Column
    private int followersCount;

    @Column
    private int followingCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public User(String username,
                String name,
                String description,
                String avatarUrl,
                String url,
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
        this.url = url;
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
