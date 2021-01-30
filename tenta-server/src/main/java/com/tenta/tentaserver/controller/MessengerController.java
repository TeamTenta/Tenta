package com.tenta.tentaserver.controller;

import com.tenta.tentaserver.domain.dto.ChatDTO;
import com.tenta.tentaserver.domain.dto.RoomDTO;
import com.tenta.tentaserver.service.MessengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessengerController {

    private static final Logger logger = LoggerFactory.getLogger(MessengerController.class);

    private final MessengerService messengerService;

    public MessengerController(MessengerService messengerService) {
        this.messengerService = messengerService;
    }

    @GetMapping("/users/{username}/messenger/rooms")
    public List<RoomDTO> getRooms(@PathVariable String username) {
        return messengerService.getRooms(username);
    }

    @PostMapping("/messenger/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoom(@RequestBody List<Long> participantIds) {
        messengerService.createRoom(participantIds);
        logger.info("[MessengerController] Create Room Success");
    }

    @GetMapping("/messenger/rooms/{room_id}/chats")
    public List<ChatDTO> getChats(@PathVariable("room_id") long roomId) {
        return messengerService.getChats(roomId);
    }
}
