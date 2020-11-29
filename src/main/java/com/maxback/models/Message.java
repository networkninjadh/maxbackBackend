package com.maxback.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Damond Howard
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	@Id
	@GeneratedValue
	@Column(name = "message_id")
	private Long messageId;
	@Column(name = "username")
	private String posterUsername;
	@Column(name = "time_posted")
	private String message;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private MessageBoard messageBoard;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MessageBoard )) return false;
		return messageId != null && messageId.equals(((MessageBoard) o).getId());
	}
	
	@Override
	public int hashCode() {
		return 52;
	}
}
