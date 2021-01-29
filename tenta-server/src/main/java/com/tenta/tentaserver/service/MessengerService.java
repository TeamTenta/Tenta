package com.tenta.tentaserver.service;

import com.tenta.tentaserver.domain.Chat;
import com.tenta.tentaserver.domain.Participant;
import com.tenta.tentaserver.domain.Room;
import com.tenta.tentaserver.domain.User;
import com.tenta.tentaserver.domain.dto.ChatDTO;
import com.tenta.tentaserver.domain.dto.ParticipantDTO;
import com.tenta.tentaserver.domain.dto.RoomDTO;
import com.tenta.tentaserver.repository.ChatRepository;
import com.tenta.tentaserver.repository.ParticipantRepository;
import com.tenta.tentaserver.repository.RoomRepository;
import com.tenta.tentaserver.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MessengerService {

    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;
    private final ChatRepository chatRepository;
    private final RoomRepository roomRepository;

    public MessengerService(UserRepository userRepository, ParticipantRepository participantRepository, ChatRepository chatRepository, RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.participantRepository = participantRepository;
        this.chatRepository = chatRepository;
        this.roomRepository = roomRepository;
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

    @Transactional
    public void createRoom(List<Long> participantIds) {
        Objects.requireNonNull(participantIds);

        Room newRoom = new Room();

        userRepository.findAllByIdIn(participantIds)
                .stream()
                .map(participant -> Participant.builder()
                        .user(participant)
                        .build())
                .forEach(participant -> {
                    newRoom.addParticipants(participant);
                    participantRepository.save(participant);
                });

        roomRepository.save(newRoom);
    }

    public List<ChatDTO> getChats(long roomId) {
        return chatRepository.findAllByRoomId(roomId)
                .stream()
                .map(ChatDTO::toChatDTO)
                .collect(Collectors.toList());
    }

    private RoomDTO toRoomDTO(Room room) {
        List<Chat> chats = chatRepository.findAllByRoom(room);

        return RoomDTO.builder()
                .id(room.getId())
                .participants(room.getParticipants().stream()
                        .map(ParticipantDTO::toParticipantDTO)
                        .collect(Collectors.toList()))
                .createAt(room.getCreatedAt())
                .lastMessageTime(chats.isEmpty() ? null : chats.get(0).getCreateAt())
                .build();
    }
}
