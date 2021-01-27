package com.tenta.tentaserver.service;

import com.tenta.tentaserver.domain.*;
import com.tenta.tentaserver.repository.ChatRepository;
import com.tenta.tentaserver.repository.ParticipantRepository;
import com.tenta.tentaserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MessengerService {

    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;
    private final ChatRepository chatRepository;

    public MessengerService(UserRepository userRepository, ParticipantRepository participantRepository, ChatRepository chatRepository) {
        this.userRepository = userRepository;
        this.participantRepository = participantRepository;
        this.chatRepository = chatRepository;
    }

    public List<RoomDTO> getRooms(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        Objects.requireNonNull(user);

        List<Participant> participants = participantRepository.findAllByUser(user);
        return participants.stream()
                .map(Participant::getRoom)
                .map(this::toRoomDTO)
                .collect(Collectors.toList());
    }

    private RoomDTO toRoomDTO(Room room) {
        List<Chat> chats = chatRepository.findByRoom(room);

        return RoomDTO.builder()
                .id(room.getId())
                .participants(room.getParticipants())
                .createAt(room.getCreateAt())
                .lastMessageTime(chats.isEmpty() ? null : chats.get(0).getCreateAt())
                .build();
    }
}
