package ru.geekbrains.winter.market.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WinterMarketCoreApplication {
	// План действий:
	// - Добавить работу с множеством корзин в редисе
	// - Замените цены продуктов/корзин с int на BigDecimal
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

	// Домашнее задание:
	// - Если пользователь не залогинен, то ему должна быть выдана общая корзина
	// - Если пользователь залогинен, то ему должна быть выдана его собственная корзина
	// - Добавить пагинацию на фронт (кнопки < Пред стр, 1, 2, 3, 4, .., След стр >)

	public static void main(String[] args) {
		SpringApplication.run(WinterMarketCoreApplication.class, args);
	}
}
