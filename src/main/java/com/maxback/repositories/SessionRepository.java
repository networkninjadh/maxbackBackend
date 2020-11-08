package com.maxback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxback.models.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

	Optional<Session> findByCustomerId(Long customerId);
	Optional<Session> findByEmployeeId(Long employeeId);
}
