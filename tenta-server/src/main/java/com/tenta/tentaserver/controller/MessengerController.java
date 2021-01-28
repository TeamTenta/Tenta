package com.tenta.tentaserver.controller;

import com.tenta.tentaserver.domain.ChatDTO;
import com.tenta.tentaserver.domain.RoomDTO;
import com.tenta.tentaserver.domain.UserDTO;
import com.tenta.tentaserver.service.MessengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessengerController {

    private final MessengerService messengerService;

    public MessengerController(MessengerService messengerService) {
        this.messengerService = messengerService;
    }

    @GetMapping("/users/{username}/messenger/rooms")
    public List<RoomDTO> getRooms(@PathVariable String username) {
        return messengerService.getRooms(username);
    }

    @PostMapping("/messenger/rooms")
    public void createRoom(@RequestBody UserDTO receiver) {

    }

    @PatchMapping("/messenger/rooms/{room_id}")
    public void updateRoom(@PathVariable("room_id") long roomId) {

    }

    @GetMapping("/messenger/rooms/{room_id}/chats")
    public List<ChatDTO> getChats(@PathVariable("room_id") long roomId) {
        return null;
    }
}