package com.example.server1;

import java.time.LocalDateTime;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

	private final SqsChatSender sqsChatSender;
	private final RedisDao redisDao;


	// 채팅 메시지 생성해서 AWS SQS로 전송
	// @CrossOrigin // 귓속말 할때 사용
	// @PostMapping("")
	// public Mono<Chat> sendMessage(@RequestBody Chat chat) {
	// 	// chat.setCreatedAt(LocalDateTime.now());
	// 	// Chat chat = new Chat(chatRequestDto);
	// 	sqsChatSender.sendMessage(chat);
	// 	return chatRepository.save(chat);
	// 	//
	// 	// return new ResponseEntity<>(new ResponseDto(200, "전송됨",chat), HttpStatus.OK);
	// }

	@Transactional
	@PostMapping("")
	public void sendMessage(@RequestBody ChatDto chatDto) {

		Chat chat = new Chat(chatDto);
		sqsChatSender.sendMessage(chat);
		redisDao.setValues(chat.getId(), chat);
	}
}
