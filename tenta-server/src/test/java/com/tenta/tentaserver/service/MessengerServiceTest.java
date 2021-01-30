package com.tenta.tentaserver.service;

import com.tenta.tentaserver.domain.Chat;
import com.tenta.tentaserver.domain.Participant;
import com.tenta.tentaserver.domain.Room;
import com.tenta.tentaserver.domain.User;
import com.tenta.tentaserver.domain.dto.ChatDTO;
import com.tenta.tentaserver.domain.dto.RoomDTO;
import com.tenta.tentaserver.exception.UserNotFoundException;
import com.tenta.tentaserver.repository.ChatRepository;
import com.tenta.tentaserver.repository.ParticipantRepository;
import com.tenta.tentaserver.repository.RoomRepository;
import com.tenta.tentaserver.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@SpringBootTest
@AutoConfigureMockMvc
class MessengerServiceTest {

    @Autowired
    private MessengerService messengerService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ParticipantRepository participantRepository;

    @MockBean
    private ChatRepository chatRepository;

    @MockBean
    private RoomRepository roomRepository;

    @Test
    void getRoomsTest() {
        User testUser = User.builder().username("testUser").build();
        Room testRoom = new Room();

        given(this.userRepository.findByUsername("testUser")).willReturn(Optional.of(testUser));

        List<Participant> participants = new ArrayList<>();
        participants.add(Participant.builder()
                .user(testUser)
                .room(testRoom)
                .build());

        given(this.participantRepository.findAllByUser(testUser)).willReturn(participants);
        given(this.chatRepository.findAllByRoom(testRoom)).willReturn(new ArrayList<>());

        List<RoomDTO> testRooms = messengerService.getRooms("testUser");
        Assertions.assertFalse(testRooms.isEmpty());

        Assertions.assertThrows(UserNotFoundException.class, () -> messengerService.getRooms("notPresentUser"));
    }

    @Test
    void createRoomTest() {
        List<Long> participantIds = new ArrayList<>();
        participantIds.add(1L);

        List<User> participants = new ArrayList<>();
        participants.add(User.builder()
                .username("testUser")
                .build());

        given(this.userRepository.findAllByIdIn(participantIds)).willReturn(participants);

        Assertions.assertDoesNotThrow(() -> this.messengerService.createRoom(participantIds));
    }

    @Test
    void getChatsTest() {
        User sender = User.builder().username("sender").build();
        Room room = new Room();
        List<Chat> chats = new ArrayList<>();
        chats.add(Chat.builder()
                .room(room)
                .sender(sender)
                .build());

        given(this.chatRepository.findAllByRoomId(0)).willReturn(chats);

        List<ChatDTO> testChats = messengerService.getChats(0);
        Assertions.assertFalse(testChats.isEmpty());

        List<ChatDTO> notPresentRoomChats = messengerService.getChats(1);
        Assertions.assertTrue(notPresentRoomChats.isEmpty());
    }
}
