package com.tenta.tentaserver.repository;

import com.tenta.tentaserver.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
