package com.example.server1;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "chat-app")
public class Chat {

	@Id
	private String id;
	private String sender;
	private String receiver;
	private String msg;
	// private LocalDateTime createdAt;

	public Chat(ChatDto chatDto){
		this.id = id().toString();
		this.sender = chatDto.getSender();
		this.receiver = chatDto.getReceiver();
		this.msg = chatDto.getMsg();
		// this.createdAt = LocalDateTime.now();
	}

	public static Long countId = 0L;
	private Long id(){
		countId += 1;
		return countId;
	}

}
