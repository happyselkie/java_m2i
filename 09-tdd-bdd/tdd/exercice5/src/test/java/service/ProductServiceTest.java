package service;

import org.example.entity.Product;
import org.example.exception.InvalidArgumentException;
import org.example.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setup(){
        productService = new ProductService();
    }

    @Test
    public void whenUpdate_thenSellInDowngrade(){
        Product product = new Product("Pomme", "fruit", 10, 10);
        productService.update(product);

        Assertions.assertEquals(9, product.getSellIn());
    }

    @Test
    public void whenSellIn_0_ThenQualityDowngradeTwice(){
        Product product = new Product("Banane", "fruit", 1, 10);
        productService.update(product);

        Assertions.assertEquals(8, product.getQuality());
    }

    @Test
    public void whenQualityUnder_0_ThenRaiseInvalidArgumentException(){
        Product product = new Product("Crème", "laitier", 1, 1);

        Assertions.assertThrows(InvalidArgumentException.class, () -> {productService.update(product);});
    }

    @Test
    public void whenQualityOver_50_ThenRaiseInvalidArgumentException(){
        Product product = new Product("Brie vieilli", "laitier", 2, 50);

        System.out.println(product.getQuality());

        Assertions.assertThrows(InvalidArgumentException.class, () -> {productService.update(product);});
    }

    @Test
    public void whenBrieSellInDowngrade_ThenQualityUprade(){
        Product product = new Product("Brie vieilli", "laitier", 10, 30);

        productService.update(product);

        Assertions.assertEquals(31, product.getQuality());
    }

    @Test
    public void whenSellInLaitierDowngrade_ThenQualityDowngradeTwice(){
        Product product = new Product("Crème", "laitier", 10, 40);

        productService.update(product);

        Assertions.assertEquals(38, product.getQuality());
    }
}
