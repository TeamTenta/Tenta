package com.tenta.tentaserver.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

@Getter
public class OAuthUser {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String registrationId;

    @Builder
    public OAuthUser(Map<String, Object> attributes,
                     String nameAttributeKey,
                     String registrationId) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.registrationId = registrationId;
    }

    public static OAuthUser of(String registrationId,
                               String userNameAttributeName,
                               Map<String, Object> attributes) {

        return OAuthUser.builder()
                .attributes(attributes)
                .registrationId(registrationId)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        Objects.requireNonNull(registrationId);

        if (registrationId.equals("github")) {
            return User.builder()
                    .username((String) attributes.get("login"))
                    .name((String) attributes.get("name"))
                    .description((String) attributes.get("bio"))
                    .avatarUrl((String) attributes.get("avatar_url"))
                    .url((String) attributes.get("html_url"))
                    .reposCount((int) getAttributes().get("public_repos"))
                    .followersCount((int) getAttributes().get("followers"))
                    .followingCount((int) getAttributes().get("following"))
                    .createdAt(LocalDateTime.parse((String) getAttributes().get("created_at"), DATE_TIME_FORMATTER))
                    .updatedAt(LocalDateTime.parse((String) getAttributes().get("updated_at"), DATE_TIME_FORMATTER))
                    .role(Role.USER)
                    .build();
        }
        return null;
    }
}
