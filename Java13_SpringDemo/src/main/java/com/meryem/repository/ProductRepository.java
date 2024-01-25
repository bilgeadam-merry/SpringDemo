package com.meryem.repository;

import com.meryem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
/**
 * # Ürün ismine göre ürünü bulunuz.
 * # Ürün isminin içerdiği harf veya kelimeye göre ürünü bulunuz.
 * # Belirli fiyat aralığındaki ürünleri listeleyiniz.
 */

      /*
    # Ürün ismine göre ürünü bulunuz.
# Ürün isminin içerdiği harf veya kelimeye göre ürünü bulunuz.
# Belirli fiyat aralığındaki ürünleri listeleyiniz.
     */
//codeium
    Optional<Product> findByProductName(String productName);
    Optional<Product> findByProductNameIgnoreCase(String productName);

    List<Product> findAllByProductNameLikeIgnoreCase(String productName);
    List<Product> findAllByProductNameContainingIgnoreCase(String productName);
    List<Product> findAllByProductPriceBetween(Double start, Double end);

    //Girilen fiyatın üstündeki ürünleri listeleyiniz.
    List<Product> findByPriceGreaterThan(double price);

    //Belirli bir stok adedinin üzerindeki ürünleri listeleyiniz
    List<Product> findByStockQuantityGreaterThan(Integer stockQuantity);

    //Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
    List<Product> findByPriceGreaterThanEqual(Double price);

    //Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
    Long countByCategory(String category);
}
