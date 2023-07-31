package com.example.server1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server1.Chat;
import com.example.server1.SqsChatSender;
import com.example.server1.respository.ChatRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

	private final ChatRepository chatRepository;
	private final SqsChatSender sqsChatSender;


	// 채팅 메시지 생성해서 AWS SQS로 전송
	@CrossOrigin // 귓속말 할때 사용
	@PostMapping("")
	public Mono<Chat> sendMessage(@RequestBody Chat chat) {
		// chat.setCreatedAt(LocalDateTime.now());
		// Chat chat = new Chat(chatRequestDto);
		sqsChatSender.sendMessage(chat);
		return chatRepository.save(chat);
		//
		// return new ResponseEntity<>(new ResponseDto(200, "전송됨",chat), HttpStatus.OK);
	}



}
