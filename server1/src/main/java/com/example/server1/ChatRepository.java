package com.example.server1;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import com.example.server1.Chat;

import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {


	@Tailable
	@Query("{sender: ?0, receiver: ?1}")
	Flux<Chat> mFindBySender(String sender, String receiver);

	@Tailable
	@Query("{room_num: ?0}")
	Flux<Chat> mFindByRoomNum(Integer roomNum);
}
