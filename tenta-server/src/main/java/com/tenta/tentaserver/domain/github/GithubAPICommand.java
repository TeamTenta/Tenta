package com.tenta.tentaserver.domain.github;

import com.tenta.tentaserver.domain.APICommand;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import java.util.Map;

public enum GithubAPICommand implements APICommand {

    LIST_PUBLIC_EVENTS_RECEIVED_BY_A_USER(HttpMethod.GET, "/users/{username}/received_events/public", Event[].class);

    public static final String BASE_URL = "https://api.github.com";
    private final HttpMethod httpMethod;
    private final String url;
    private final Class<?> type;

    GithubAPICommand(HttpMethod httpMethod, String url, Class<?> type) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.type = type;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    @Override
    public String getURL(Map<String, String> map) {
        String modifyURL = this.url;
        for (Map.Entry<String, String> mapEntry : map.entrySet()) {
            modifyURL = modifyURL.replaceAll(mapEntry.getKey(), mapEntry.getValue());
        }
        modifyURL = modifyURL.replaceAll("[{}]", "");
        return BASE_URL + modifyURL;
    }

    @Override
    public HttpEntity<String> getHttpEntity() {
        return null;
    }

    @Override
    public Class<?> getType() {
        return type;
    }
}
