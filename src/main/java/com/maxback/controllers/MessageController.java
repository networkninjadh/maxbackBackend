package com.maxback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxback.models.MessageBoard;
import com.maxback.repositories.MessageBoardRepository;

@RestController
@RequestMapping("/message-api/")
public class MessageController {

	@Autowired
	private MessageBoardRepository messages;
	
	@GetMapping("/messages")
	public List<MessageBoard> getMessageBoard() {
		return messages.findAll();
	}
}
