package com.example.sever2;

import java.util.Map;

import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SqsChatListener {
	// private final ChatService chatService;
	//
	// public SqsChatListener(ChatService chatService){
	// 	this.chatService = chatService;
	// }

	@SqsListener(value = "Random-chat-Queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void listen(@Payload Chat chat,
		@Headers Map<String, String> headers) {
		System.out.println("여기는 리스너");
		log.info("{}", chat);
		log.info("{}", headers);
		// log.info("{}", ack != null);
		// chatService.getChat(chat);
	}
}