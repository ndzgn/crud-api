package learn.spring_boot.crud.controller;

import jakarta.validation.Valid;
import learn.spring_boot.crud.entity.CreateProductDTO;
import learn.spring_boot.crud.entity.Product;
import learn.spring_boot.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) throws Exception
    {
        Product product = productService.readById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody CreateProductDTO productDTO) throws Exception
    {
        Product product = productService.create(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
