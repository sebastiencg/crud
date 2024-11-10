package com.miantsebastien.crud.controller;

import com.miantsebastien.crud.model.Product;
import com.miantsebastien.crud.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }


    @PostMapping ("/product/create")
    public Product createProduct(@RequestBody Product product){

        return productRepository.save(product);
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable long id){
        return productRepository.findById(id).
                orElseThrow(() -> new RuntimeException(
                        "Produit non trouvé avec l'id : " + id
                ));

    }

    @PatchMapping("/product/{id}/update")
    public Product updateProduct(@PathVariable Long id ,@RequestBody Product product){
         return productRepository.findById(id).map(
                 product1 -> {
                     product1.setName(product.getName());
                     product1.setDescription(product.getDescription());
                     product1.setPrice(product.getPrice());
                     product1.setQuantity(product.getQuantity());
                     return productRepository.save(product1);
                 }
         ).orElseThrow(()->new RuntimeException("aucun produit modifier"));
    }
    @DeleteMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        return productRepository.findById(id).map(product -> {
            productRepository.delete(product);
            return "Produit supprimé avec succès";
        }).orElseThrow(() -> new RuntimeException("Produit non trouvé pour suppression avec l'id : " + id));
    }
}
