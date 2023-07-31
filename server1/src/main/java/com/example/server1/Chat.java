package com.example.server1;

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
	private Integer room_num;
}