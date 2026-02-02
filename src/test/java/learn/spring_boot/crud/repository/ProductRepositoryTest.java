package learn.spring_boot.crud.repository;

import jakarta.persistence.EntityManager;
import learn.spring_boot.crud.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
@DisplayName("Test de la couche repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    private Product total;
    private Product tradex;
    private Product gazcom;

    @BeforeEach
    void  setUp()
    {
        total = Product.builder()
                .brand("Total")
                .mass(12.5)
                .price(new BigDecimal("6500"))
                .build();
        tradex = Product.builder()
                .brand("Tradex")
                .mass(12.5)
                .price(new BigDecimal("6500"))
                .build();
        gazcom = Product.builder()
                .brand("Gazcom")
                .mass(12.5)
                .price(new BigDecimal("6500"))
                .build();

        entityManager.persist(total);
        entityManager.persist(tradex);
        entityManager.persist(gazcom);
    }

    @Test
    void shouldCreateProduct()
    {
        //Given
        total = Product.builder()
                .brand("Total")
                .mass(12.5)
                .price(new BigDecimal("6500"))
                .build();
        //WHEN
        Product product = productRepository.save(total);
        //THEN
       assertTrue(product.getBrand().equals(total.getBrand()));
    }

    @Test
    void shouldFindAllProducts()
    {
        //Act
        List<Product> productList = productRepository.findAll();

        //Assert
        assertEquals(3, productList.size());
    }

    @Test
    void shouldFindByBrand()
    {
        //When
        Boolean product = productRepository.existsByBrandIgnoreCase("Total");
        //Then
        assertTrue(product);

    }
}