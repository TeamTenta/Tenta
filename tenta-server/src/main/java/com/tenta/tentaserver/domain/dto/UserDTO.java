package com.tenta.tentaserver.domain.dto;

import com.tenta.tentaserver.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserDTO implements Serializable {

    private final long id;
    private final String username;
    private final String name;
    private final String avatarUrl;
    private final String url;

    @Builder
    public UserDTO(long id, String username, String name, String avatarUrl, String url) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.url = url;
    }

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .avatarUrl(user.getAvatarUrl())
                .url(user.getUrl())
                .build();
    }
}