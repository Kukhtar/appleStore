package ua.ipz4.aplleStore.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.ipz4.aplleStore.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
