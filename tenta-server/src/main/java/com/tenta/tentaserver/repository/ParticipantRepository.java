package com.tenta.tentaserver.repository;

import com.tenta.tentaserver.domain.Participant;
import com.tenta.tentaserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    List<Participant> findAllByUser(User user);
}
