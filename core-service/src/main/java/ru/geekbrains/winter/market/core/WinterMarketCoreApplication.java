package ru.geekbrains.winter.market.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WinterMarketCoreApplication {
	// План действий:
	// - + Добавить работу с множеством корзин в редисе
	// - + Замените цены продуктов/корзин с int на BigDecimal
	// - Добавить страницу с заказами
	// - + Добавьте фильтрацию/пагинация товаров (по цене мин/макс, названию), поговорить про спецификации
	// - Добавить правила безопасности на гейтвей
	// - Поговорить про докер
	// - Добавить платежную систему
	// - + Распилить фронт на страницы
	// - + Поговорить про работу над МСами
	// - Wiremock
	// - + Поговорить про профили
	// - Иерархия товаров
	// - Добавить пагинацию на фронт (кнопки < Пред стр, 1, 2, 3, 4, .., След стр >)

	// Домашнее задание:
	// - Реализовать мерж гостевой корзины с корзиной юзера, в момент авторизации

	public static void main(String[] args) {
		SpringApplication.run(WinterMarketCoreApplication.class, args);
	}
}
