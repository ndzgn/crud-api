package learn.spring_boot.crud.mapper;

import learn.spring_boot.crud.entity.CreateProductDTO;
import learn.spring_boot.crud.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, CreateProductDTO>{
    /**
     * Map DTO to his Entity
     *
     * @param dto the DTO
     * @return E entity
     */
    @Override
    public Product toEntity(CreateProductDTO dto) {
        return Product.builder()
                .brand(dto.getBrand())
                .mass(dto.getMass())
                .price(dto.getPrice())
                .build();
    }

    /**
     * Map Entity to his DTO
     *
     * @param product the Entity
     * @return D dto
     */
    @Override
    public CreateProductDTO toDTO(Product product) {
        return CreateProductDTO.builder()
                .brand(product.getBrand())
                .mass(product.getMass())
                .price(product.getPrice())
                .build();
    }
}
