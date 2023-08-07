package tdtu.edu.vn.Lab10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.Lab10.models.Product;
import tdtu.edu.vn.Lab10.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Product getProductById(Long id){
        return productRepository.getById(id);
    }

    public List<Product> getProductsByBrandsAndPriceRange(List<String> brands, double minPrice, double maxPrice){
        return productRepository.findProductsByBrandInAndPriceBetween(brands, minPrice, maxPrice);
    }
    public List<Product> getProductsByBrands(List<String> brands){
        return productRepository.findProductsByBrandIn(brands);
    }
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findProductsByPriceBetween(minPrice, maxPrice);
    }
    public List<Product> getProductsByName(String name){
        return productRepository.findProductsByNameContainingIgnoreCase(name);
    }
}
