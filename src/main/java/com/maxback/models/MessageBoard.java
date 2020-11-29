package com.maxback.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message_boards")
public class MessageBoard {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "messageBoard", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Message> messages = new HashSet<Message>();
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
}
