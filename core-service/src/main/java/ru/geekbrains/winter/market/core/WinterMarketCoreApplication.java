package ru.geekbrains.winter.market.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WinterMarketCoreApplication {
	// Домашнее задание:
	// 1. Разобраться со структурой проекта
	// 2. В core сервисе добавьте интеграцию с МС корзин при оформлении заказа
	// 3. * Вынесите url для интеграций в application.yaml (аннотация @Value)
	// 4. * Вынесите фронт в отдельный МС
	// 5. ***** Попробуйте вынести получение токена в отдельный МС

	public static void main(String[] args) {
		SpringApplication.run(WinterMarketCoreApplication.class, args);
	}
}
