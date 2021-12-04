package ua.ipz4.aplleStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.ipz4.aplleStore.model.Product;
import ua.ipz4.aplleStore.repository.ProductRepository;


@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String getProducts() {
        StringBuilder result = new StringBuilder();
        productRepository.findAll().forEach(x -> result.append("ID - " + x.getId() + " Name - " + x.getName() + "\n"));
        return result.toString();
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
}
