package com.maxback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxback.models.MessageBoard;

public interface MessageBoardRepository extends JpaRepository<MessageBoard, Long> {

}
