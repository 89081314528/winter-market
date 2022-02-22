package ru.geekbrains.spring.winter.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WinterMarketApplication {
	// Домашнее задание:
	// 1. Группировка продуктов в корзине
	// 2. Добавляете возможность по кнопке на фронте очищать корзину
	// 3. * Добавьте возможность увеличивать/уменьшать кол-во товаров в одной "продуктовой строке" корзины
	// 4. * Добавьте возможность удалять "продуктовую строку" корзины

	public static void main(String[] args) {
		SpringApplication.run(WinterMarketApplication.class, args);
	}
}
