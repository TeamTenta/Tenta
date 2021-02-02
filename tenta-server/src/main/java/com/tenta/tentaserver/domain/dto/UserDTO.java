package com.tenta.tentaserver.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenta.tentaserver.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6170457140654066785L;

    private final long id;
    private final String username;
    private final String name;

    @JsonProperty("avatar_url")
    private final String avatarUrl;

    @JsonProperty("html_url")
    private final String htmlUrl;

    @Builder
    public UserDTO(long id, String username, String name, String avatarUrl, String htmlUrl) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .avatarUrl(user.getAvatarUrl())
                .htmlUrl(user.getHtmlUrl())
                .build();
    }
}
