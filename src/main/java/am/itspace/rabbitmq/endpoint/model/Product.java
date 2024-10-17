package am.itspace.rabbitmq.endpoint.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Product {

	private String name;

	private String description;

	private Double price;

	private int quantity;

	private LocalDateTime created;
}
