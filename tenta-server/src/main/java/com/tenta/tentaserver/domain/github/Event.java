package com.tenta.tentaserver.domain.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;

@JsonIgnoreProperties({"public", "org"})
public class Event {

    public long id;
    public String type;
    public Actor actor;
    public Repository repo;
    public Map<String, Object> payload;

    @JsonProperty("create_at")
    public LocalDateTime createAt;
}
