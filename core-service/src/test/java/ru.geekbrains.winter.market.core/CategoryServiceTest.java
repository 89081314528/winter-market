package ru.geekbrains.winter.market.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.winter.market.core.entities.Category;
import ru.geekbrains.winter.market.core.repositories.CategoryRepository;
import ru.geekbrains.winter.market.core.services.CategoryService;
import java.util.Optional;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void findByTitleTest(){
        Category category = new Category();
        category.setId(1L);
        category.setTitle("other");

        Mockito.doReturn(Optional.of(category)).when(categoryRepository).findByTitle("other");
        Assertions.assertEquals(Optional.of(category), categoryService.findByTitle("other"));
    }
}
