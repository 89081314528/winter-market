package ru.geekbrains.winter.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.winter.market.core.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal min, BigDecimal max);
    List<Product> getByTitleStartingWith(String name);

}
