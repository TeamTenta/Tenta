package com.tenta.tentaserver.domain.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ReferenceType implements Payload {

    @JsonProperty("ref_type")
    private final String refType;

    @Builder
    public ReferenceType(String refType) {
        this.refType = refType;
    }
}
