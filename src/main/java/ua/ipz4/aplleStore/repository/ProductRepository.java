package ua.ipz4.aplleStore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.ipz4.aplleStore.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
