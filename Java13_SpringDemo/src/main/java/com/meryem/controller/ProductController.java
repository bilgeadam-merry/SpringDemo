package com.meryem.controller;

import com.meryem.entity.Product;
import com.meryem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/save")
    public Product save(Product product) {
        return productService.save(product);
    }

    @GetMapping("/find-all")
    public List<Product> findAll() {
        return productService.finALl();
    }

    @GetMapping("/find-by-id")
    public Optional<Product> findById(Long id) {
        return productService.findById(id);
    }

    @GetMapping("/update")
    public Product update(Product product) {
        return productService.update(product);
    }


    @GetMapping("/find-by-product-name")
    public Optional<Product> findByProductName(String productName) {
        return productService.findByProductName(productName);
    }

    @GetMapping("/find-by-product-name-ignore-case")
    public Optional<Product> findByProductNameIgnoreCase(String productName) {
        return productService.findByProductNameIgnoreCase(productName);
    }

    @GetMapping("/find-all-by-product-name-like-ignore-case") //-> Bunun yerine containing kullanmak gerekiyor.
    public List<Product> findAllByProductNameLikeIgnoreCase(String productName) {
        return productService.findAllByProductNameLikeIgnoreCase(productName);
    }

    @GetMapping("/find-all-by-product-name-containing-ignore-case")
    //http://localhost:8080/product/find-all-by-product-name-containing-ignore-case?name=Be
    public List<Product> findAllByProductNameContainingIgnoreCase(String name) {
        return productService.findAllByProductNameContainingIgnoreCase(name);
    }

    @GetMapping("/find-all-by-product-price-between")
    public List<Product> findAllByProductPriceBetween(Double start, Double end) {
        return productService.findAllByProductPriceBetween(start, end);
    }


    //Girilen fiyatın üstündeki ürünleri listeleyiniz.

    @GetMapping("/price-above")
    public ResponseEntity<List<Product>> getProductsPriceAbove(@RequestParam("price") double price) {
        List<Product> products = productService.getProductsPriceAbove(price);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //Belirli bir stok adedinin üzerindeki ürünleri listeleyiniz
    @GetMapping("/stock-quantity-above")
    public ResponseEntity<List<Product>> getProductsStockQuantityAbove(@RequestParam("stockQuantity") int stockQuantity) {
        List<Product> products = productService.getProductsStockQuantityAbove(stockQuantity);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
    @GetMapping("/price-equal-and-above")
    public ResponseEntity<List<Product>> getProductsPriceEqualAndAbove(@RequestParam("price") Double price) {
        List<Product> products = productService.getProductsPriceEqualAndAbove(price);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
    @GetMapping("/products-count-by-category")
    public ResponseEntity<Long> getProductsCountByCategory(@RequestParam("category") String category) {
        Long productCount = productService.getProductsCountByCategory(category);
        return new ResponseEntity<>(productCount, HttpStatus.OK);
    }
}
