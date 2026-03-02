package learn.spring_boot.crud.controller;

import jakarta.validation.Valid;
import learn.spring_boot.crud.entity.CreateProductDTO;
import learn.spring_boot.crud.entity.Product;
import learn.spring_boot.crud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    Path imagesPath = Paths.get("images");

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) throws Exception
    {
        Product product = productService.readById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> products = productService.readAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestParam("product") CreateProductDTO productDTO, @RequestParam("file")MultipartFile file) throws Exception
    {
        if(!Files.exists(imagesPath))
        {
            Files.createDirectory(imagesPath);
        }

        String fileName = file.getOriginalFilename();

        Path path = imagesPath.resolve(fileName);

//        UrlResource resource = new UrlResource(path.toUri());

//        log.info(String.valueOf(resource));

        productDTO.setFile_url(path.toString());

        Product product = productService.create(productDTO);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody CreateProductDTO dto, int id)
    {
        Product product = productService.update(dto, id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id)
    {
        productService.delete(id);
    }
}
