package com.primetech.primetech_backend.repository;

import com.primetech.primetech_backend.entity.Payments;

import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

}
