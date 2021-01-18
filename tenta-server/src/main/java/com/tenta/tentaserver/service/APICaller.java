package com.tenta.tentaserver.service;

import com.tenta.tentaserver.domain.APICommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public abstract class APICaller<C extends APICommand> {

    RestTemplate caller;

    protected APICaller(RestTemplate caller) {
        this.caller = caller;
    }

    public Object call(C command, Map<String, String> pathParams) {
        ResponseEntity<?> exchange = caller.exchange(command.getURL(pathParams), command.getHttpMethod(), null, command.getType());
        return exchange.getBody();
    }

    public Object call(C command, Map<String, String> pathParams, Map<String, String> params) {
        ResponseEntity<?> exchange = caller.exchange(command.getURL(pathParams), command.getHttpMethod(), null, command.getType(), params);
        return exchange.getBody();
    }
}
