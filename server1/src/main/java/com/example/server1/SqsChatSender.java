package com.example.server1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;

@Service
public class SqsChatSender {

	private final QueueMessagingTemplate queueMessagingTemplate;

	@Autowired
	public SqsChatSender(AmazonSQS amazonSQS) {
		this.queueMessagingTemplate = new QueueMessagingTemplate((AmazonSQSAsync) amazonSQS);
	}

	public void send(String member) {
		Message<String> sendMessage = MessageBuilder.withPayload(member).build();
		queueMessagingTemplate.send("Random-chat-Queue", sendMessage);
	}

	public void sendMessage(Chat chat) {
		System.out.println("여기는 샌드 메세지");
		queueMessagingTemplate.convertAndSend("Random-chat-Queue", chat);
		System.out.println("큐메세징 완료");
	}


}