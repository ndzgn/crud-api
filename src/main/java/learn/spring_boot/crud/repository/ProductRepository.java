package learn.spring_boot.crud.repository;

import learn.spring_boot.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Boolean existsByBrandIgnoreCase(String brand);
}
