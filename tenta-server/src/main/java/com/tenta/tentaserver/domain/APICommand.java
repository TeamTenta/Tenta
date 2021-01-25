package com.tenta.tentaserver.domain;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import java.util.Map;

public interface APICommand {

    HttpMethod getHttpMethod();
    String getURL(Map<String, String> map);
    HttpEntity<String> getHttpEntity();
    Class<?> getType();
}
