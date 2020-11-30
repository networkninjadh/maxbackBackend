package com.maxback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxback.models.Message;
import com.maxback.models.MessageBoard;
import com.maxback.repositories.MessageBoardRepository;
import com.maxback.repositories.MessageRepository;

@RestController
@RequestMapping("/message-api/")
public class MessageController {

	@Autowired
	private MessageBoardRepository messageBoards;
	
	@GetMapping("/messageboards")
	public List<MessageBoard> getMessageBoard() {
		return messageBoards.findAll();
	}
	
	@PostMapping("/messageboard/new")
	public MessageBoard newMessageBoard(@AuthenticationPrincipal UserDetails userDetails) {
		MessageBoard messageBoard = new MessageBoard();
		messageBoard.setAdminUsername(userDetails.getUsername());
		return messageBoards.save(messageBoard);
	}
	
	@PostMapping("/messageboards/{message_board_id}/message/new")
	public Message newMessage(@PathVariable(name = "message_board_id") Long messageBoardId, @RequestBody Message message, @AuthenticationPrincipal UserDetails userDetails) {
		MessageBoard messageBoard = messageBoards.findById(messageBoardId)
				.orElseThrow();
		Message newMessage = new Message();
		newMessage.setMessage(message.getMessage());
		newMessage.setMessageBoard(messageBoard);
		newMessage.setPosterUsername(userDetails.getUsername());
		messageBoard.addMessage(newMessage);
		messageBoards.save(messageBoard);
		return newMessage;
	}
}
