package am.itspace.rabbitmq.endpoint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {

	@Value("${queue.name}")
	private String queueName;

	private final AmqpTemplate amqpTemplate;

	public void send(String product) {
		amqpTemplate.convertAndSend(queueName, product);
	}

}
