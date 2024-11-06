package com.primetech.primetech_backend.repository;

import com.primetech.primetech_backend.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository <Session,Integer> {

    @Query(value = "select * from Session where room_id =:roomId and timeslot_id =:timeslotId", nativeQuery = true)
    Session findEspefic(Integer roomId, Integer timeslotId);
}
