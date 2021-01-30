package com.tenta.tentaserver.controller;

import com.tenta.tentaserver.domain.dto.ChatDTO;
import com.tenta.tentaserver.domain.dto.ParticipantDTO;
import com.tenta.tentaserver.domain.dto.RoomDTO;
import com.tenta.tentaserver.domain.dto.UserDTO;
import com.tenta.tentaserver.exception.UserNotFoundException;
import com.tenta.tentaserver.service.MessengerService;
import com.tenta.tentaserver.utils.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessengerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private MessengerController messengerController;

    @MockBean
    private MessengerService messengerService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(messengerController)
                .setControllerAdvice(new ExceptionHandlerController())
                .build();
    }

    @Test
    void getRoomsResponseTest() throws Exception {
        List<RoomDTO> roomsGiven = new ArrayList<>();
        List<ParticipantDTO> participants = new ArrayList<>();
        participants.add(ParticipantDTO.builder()
                .user(UserDTO.builder()
                        .id(1)
                        .username("presentUser")
                        .name("name")
                        .avatarUrl("avatar_url")
                        .url("url")
                        .build())
                .build());

        roomsGiven.add(RoomDTO.builder()
                .id(1)
                .participants(participants)
                .build());

        given(this.messengerService.getRooms("presentUser")).willReturn(roomsGiven);
        given(this.messengerService.getRooms("notPresentUser")).willThrow(new UserNotFoundException("notPresentUser"));

        List<RoomDTO> rooms = messengerController.getRooms("presentUser");
        Assertions.assertEquals(roomsGiven, rooms);

        mockMvc.perform(get("/users/{username}/messenger/rooms", "presentUser"))
                .andDo(print())
                .andExpect(status().is(200));

        mockMvc.perform(get("/users/{username}/messenger/rooms", "notPresentUser"))
                .andDo(print())
                .andExpect(status().is(400));
    }

    @Test
    void createRoomTest() throws Exception {
        List<Long> participantIds = new ArrayList<>();
        participantIds.add(1L);

        mockMvc.perform(post("/messenger/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Strings.asJsonString(participantIds)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void getChatsTest() throws Exception {
        List<ChatDTO> chatsGiven = new ArrayList<>();
        chatsGiven.add(ChatDTO.builder()
                .id(1)
                .content("chatting")
                .sender(UserDTO.builder()
                        .id(1)
                        .username("presentUser")
                        .name("name")
                        .avatarUrl("avatar_url")
                        .url("url")
                        .build())
                .build());

        given(this.messengerService.getChats(1)).willReturn(chatsGiven);

        List<ChatDTO> chats = messengerController.getChats(1);
        Assertions.assertEquals(chatsGiven, chats);

        mockMvc.perform(get("/messenger/rooms/{room_id}/chats", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
