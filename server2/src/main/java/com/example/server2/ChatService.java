package com.example.server2;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class ChatService {
	private final Sinks.Many<Chat> sink = Sinks.many().unicast().onBackpressureBuffer();

	public void getChat(Chat chat){
		sink.tryEmitNext(chat);
	}

	public Flux<Chat> getChatFlux(){
		return sink.asFlux();
	}
}

