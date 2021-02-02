package com.tenta.tentaserver.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenta.tentaserver.domain.Chat;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class ChatDTO implements Serializable {

    private static final long serialVersionUID = -570655422953810178L;

    private final long id;
    private final UserDTO sender;
    private final String content;

    @JsonProperty("created_at")
    private final LocalDateTime createdAt;

    @Builder
    public ChatDTO(long id, UserDTO sender, String content, LocalDateTime createdAt) {
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static ChatDTO toChatDTO(Chat chat) {
        return ChatDTO.builder()
                .id(chat.getId())
                .sender(UserDTO.toUserDTO(chat.getSender()))
                .content(chat.getContent())
                .createdAt(chat.getCreateAt())
                .build();
    }
}
