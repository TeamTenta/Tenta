package com.tenta.tentaserver.service;

import com.tenta.tentaserver.domain.github.Event;
import com.tenta.tentaserver.domain.github.GithubAPICommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GithubAPICaller extends APICaller<GithubAPICommand> {

    public GithubAPICaller(RestTemplate caller) {
        super(caller);
    }

    public List<Event> getEventList(String username) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);

        Event[] call = (Event[]) this.call(GithubAPICommand.LIST_PUBLIC_EVENTS_RECEIVED_BY_A_USER, map);
        return Arrays.stream(call).collect(Collectors.toList());
    }
}
