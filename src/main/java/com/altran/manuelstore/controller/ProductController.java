package com.altran.manuelstore.controller;

import com.altran.manuelstore.model.Product;
import com.altran.manuelstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productRepository.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Product product){
        return ResponseEntity.ok(productRepository.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        productRepository.deleteById(id);
        return ResponseEntity.ok("RIP");
    }
}
