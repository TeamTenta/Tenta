package com.tenta.tentaserver.service;

import com.tenta.tentaserver.domain.FeedDTO;
import com.tenta.tentaserver.domain.github.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedService {

    GithubAPICaller githubAPICaller;

    public FeedService(GithubAPICaller githubAPICaller) {
        this.githubAPICaller = githubAPICaller;
    }

    public List<FeedDTO> getFeeds(String username) {
        List<Event> eventList = githubAPICaller.getEventList(username);
        return eventList.stream().map(Event::toFeedDTO).collect(Collectors.toList());
    }
}
