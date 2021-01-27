package com.tenta.tentaserver.controller;

import com.tenta.tentaserver.domain.FeedDTO;
import com.tenta.tentaserver.service.FeedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    FeedService feedService;

    public MainController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/users/{username}/feeds")
    public List<FeedDTO> feeds(@PathVariable("username") String username) {
        return feedService.getFeeds(username);
    }
}
