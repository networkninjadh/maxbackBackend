package com.maxback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxback.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

}
