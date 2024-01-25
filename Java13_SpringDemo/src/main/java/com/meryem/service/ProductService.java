package com.meryem.service;

import com.meryem.entity.Product;
import com.meryem.repository.ProductRepository;
import com.meryem.utility.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IService<Product,Long> {

    private final ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        return productRepository.save(Product.builder()
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .productPrice(product.getProductPrice())
                .productUnitInStock(product.getProductUnitInStock())
                .productDescription(product.getProductDescription())
                .build());
    }

    @Override
    public Product update(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> t) {
        return null;
    }

    @Override
    public void delete(Product product) {
    productRepository.delete(product);
    }

    @Override
    public void deleteByID(Product product) {
        productRepository.delete(product);

    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> finALl() {
        return productRepository.findAll();
    }

    public Optional<Product> findByProductName(String productName){
        if(productName.equalsIgnoreCase(productRepository.findByProductName(productName).get().getProductName())){
            return productRepository.findByProductName(productName);
        }
        return null;
    }

    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productRepository.findByProductNameIgnoreCase(productName);
    }
    public  List<Product> findAllByProductNameLikeIgnoreCase(String productName){
        return productRepository.findAllByProductNameLikeIgnoreCase(productName);
    }

    public List<Product> findAllByProductNameContainingIgnoreCase(String productName){
        return productRepository.findAllByProductNameContainingIgnoreCase(productName);
    }

    public List<Product> findAllByProductPriceBetween(Double start, Double end){
        return productRepository.findAllByProductPriceBetween(start,end);
    }

    //Girilen fiyatın üstündeki ürünleri listeleyiniz.
    public List<Product> getProductsPriceAbove(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }
    //Belirli bir stok adedinin üzerindeki ürünleri listeleyiniz
    public List<Product> getProductsStockQuantityAbove(int stockQuantity) {
        return productRepository.findByStockQuantityGreaterThan(stockQuantity);
    }

    //Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
    public List<Product> getProductsPriceEqualAndAbove(Double price) {
        return productRepository.findByPriceGreaterThanEqual(price);
    }

    //Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.

    public Long getProductsCountByCategory(String category) {
        return productRepository.countByCategory(category);
    }


}
