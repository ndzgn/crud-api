package learn.spring_boot.crud.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CRUD<E,D> {
    /**
     * Delete a product
     * @param id the product id
     * */
    void delete(int id) throws Exception;

    /**
     * Create a product
     * @param dto the create product dto
     * @return E product
     * */
    E create(D dto) throws Exception;


    /**
     * Select all the products in the database
     * @return List<E> list of products
     * */
    List<E> readAll();


    /**
     * Select product by id
     * @param id the product id
     * @return E product
     * */
    E readById(int id) throws Exception;

    /**
     * update product
     * @param dto
     * @return E entity
     * */
    E update(D dto, int id);

}
