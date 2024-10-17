package am.itspace.rabbitmq.endpoint;

import am.itspace.rabbitmq.endpoint.model.Product;
import am.itspace.rabbitmq.endpoint.service.MessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final MessageSender messageSender;
	private final ObjectMapper objectMapper;

	@PostMapping("/send")
	public ResponseEntity<?> send(@RequestBody Product product ) throws JsonProcessingException {
		if (product==null){
			return new ResponseEntity<>(HttpStatusCode.valueOf(400));
		}
		String valueAsString = objectMapper.writeValueAsString(product);
		messageSender.send(valueAsString);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}

}
