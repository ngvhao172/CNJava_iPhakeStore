package tdtu.edu.vn.Lab10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.Lab10.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductsByBrandInAndPriceBetween(List<String> brands, double firstPrice, double secondPrice);

    List<Product> findProductsByPriceBetween(double minPrice, double maxPrice);

    List<Product> findProductsByBrandIn(List<String> brands);
}
