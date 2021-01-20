package com.tenta.tentaserver.domain.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SponsorshipEvent implements Payload {

    private final String action;

    @JsonProperty("effectiveDate")
    private final String effectiveDate;

    @Builder
    public SponsorshipEvent(String action, String effectiveDate) {
        this.action = action;
        this.effectiveDate = effectiveDate;
    }
}
