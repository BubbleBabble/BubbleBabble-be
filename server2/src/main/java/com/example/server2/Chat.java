package com.example.server2;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	private Integer roomId;


	// private LocalDateTime createdAt;

}
