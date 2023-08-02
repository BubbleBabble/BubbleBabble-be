package com.example.server2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RestController
public class ChatController {

	private final ChatRepository chatRepository;
	private final ChatService chatService;
	@Autowired
	public ChatController(ChatRepository chatRepository, ChatService chatService){
		this.chatRepository = chatRepository;
		this.chatService = chatService;
	}

	@CrossOrigin
	@GetMapping(value = "/chat/listen", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Chat> listen(){

		return chatService.getChatFlux();
	}

	// // AWS SQS에서 메시지를 수신
	// @SqsListener("Random-chat-Queue")
	// public void receiveMessage(Chat chat) {
	// 	chatRepository.save(chat);
	// }

	// private final ChatRepository chatRepository;
	//
	// @CrossOrigin
	// @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	// public Flux<Chat> getMsg(@PathVariable String sender, @PathVariable String receiver) {
	// 	return chatRepository.mFindBySender(sender, receiver)
	// 		.subscribeOn(Schedulers.boundedElastic());
	// }
	//
	// @CrossOrigin
	// @GetMapping(value = "/chatrooms/{roomNum}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	// public Flux<Chat> findByRoomNum(@PathVariable Integer roomNum) {
	// 	return chatRepository.mFindByRoomNum(roomNum)
	// 		.subscribeOn(Schedulers.boundedElastic());
	// }

}

