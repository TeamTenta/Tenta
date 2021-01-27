package com.tenta.tentaserver.repository;

import com.tenta.tentaserver.domain.Chat;
import com.tenta.tentaserver.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByRoom(Room room);
}
