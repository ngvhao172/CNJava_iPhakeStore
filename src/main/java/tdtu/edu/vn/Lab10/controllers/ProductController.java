package tdtu.edu.vn.Lab10.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tdtu.edu.vn.Lab10.models.CartManagement;
import tdtu.edu.vn.Lab10.models.Product;
import tdtu.edu.vn.Lab10.services.CartManagementService;
import tdtu.edu.vn.Lab10.services.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartManagementService cartManagementService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String homePage(Model model){
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("listProduct",productList);
        return "index";
    }
    @GetMapping("/detail/{id}")
    public String detailPage(@PathVariable("id") Long productId, Model model){
        Product product  = productService.getProductById(productId);
        model.addAttribute(product);
        return "detail";
    }
    @PostMapping("/filter")
    public String getProductsFilter(@RequestParam(value = "brand", defaultValue = "") List<String> brands,
                                    @RequestParam(value = "minPrice", defaultValue = "0") double minPrice,
                                    @RequestParam(value = "maxPrice", defaultValue = "99999999") double maxPrice,
                                    Model model){
        if (!brands.isEmpty() && maxPrice==99999999) {
            List<Product> productList = productService.getProductsByBrands(brands);
            model.addAttribute("brandsChecked", brands);
            model.addAttribute("listProduct", productList);

        } else if(brands.isEmpty()){
            List<Product> productList = productService.getProductsByPriceRange(minPrice, maxPrice);
            model.addAttribute("listProduct", productList);
        }
        else{
            List<Product> productList = productService.getProductsByBrandsAndPriceRange(brands,minPrice, maxPrice);
            model.addAttribute("brandsChecked", brands);
            model.addAttribute("listProduct", productList);
        }
        return "index";
    }

//    @GetMapping("/cart")
//    public String cartPage(){
////        Product product  = productService.getProduct(productId);
////        model.addAttribute(product);
//        return "cart";
//    }
}