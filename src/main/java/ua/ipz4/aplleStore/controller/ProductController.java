package ua.ipz4.aplleStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.ipz4.aplleStore.model.Product;
import ua.ipz4.aplleStore.repository.ProductRepository;


@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Product> findAll(Pageable pageable) {
        Page<Product> allProductsSortedByName = productRepository.findAll(pageable);
        return allProductsSortedByName;
    }
    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getById(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Product product) {
        productRepository.save(product);
    }


}
