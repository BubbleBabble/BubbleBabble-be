package com.example.server1;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatDto {
	private String sender;
	private String receiver;
	private String msg;
	// private LocalDateTime createdAt;
}