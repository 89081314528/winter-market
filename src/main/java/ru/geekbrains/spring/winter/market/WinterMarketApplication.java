package ru.geekbrains.spring.winter.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WinterMarketApplication {
	// Домашнее задание:
	// 1. Разобраться в базовом взаимодействии бэк <-> фронт
	// 2. Попробуйте реализовать простейший вариант корзины в виде бина-синглтона:
	//    - Создаете бин Cart в, который может хранить список товаров (List<Product>)
	//    - На фронте делаете кнопки "добавить в корзину" рядом с каждым товаром
	//    - При нажатии на кнопку, товар должен попасть в корзину
	//    - Под таблицей с товарами отрисуйте таблицу "Корзина", с набором товаров из корзины

	public static void main(String[] args) {
		SpringApplication.run(WinterMarketApplication.class, args);
	}
}
