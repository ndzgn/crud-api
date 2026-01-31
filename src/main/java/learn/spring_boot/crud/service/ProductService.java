package learn.spring_boot.crud.service;

import jakarta.transaction.Transactional;
import learn.spring_boot.crud.entity.CreateProductDTO;
import learn.spring_boot.crud.entity.Product;
import learn.spring_boot.crud.exception.ProductAllReadyExistsException;
import learn.spring_boot.crud.exception.ProductNotFoundException;
import learn.spring_boot.crud.mapper.Mapper;
import learn.spring_boot.crud.mapper.ProductMapper;
import learn.spring_boot.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CRUD<Product, CreateProductDTO> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void delete(int id) throws ProductNotFoundException {
        Product product = this.readById(id);
        productRepository.delete(product);
    }


    @Override
    public Product create(CreateProductDTO dto) throws Exception {
        if (productRepository.existsByBrandIgnoreCase(dto.getBrand()))
        {
            throw new ProductAllReadyExistsException("Product all ready exists");
        }
        Product product = productMapper.toEntity(dto);
        return productRepository.save(product);
    }


    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }


    @Override
    public Product readById(int id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }


    @Override
    @Transactional
    public Product update(CreateProductDTO dto, int id) throws ProductNotFoundException {
        Product product = this.readById(id);
        product.setBrand(dto.getBrand());
        product.setPrice(dto.getPrice());
        product.setMass(dto.getMass());
        return productRepository.save(product);
    }
}
