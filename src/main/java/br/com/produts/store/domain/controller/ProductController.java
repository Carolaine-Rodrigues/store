package br.com.produts.store.domain.controller;

import br.com.produts.store.domain.dto.ProductsRequestDTO;
import br.com.produts.store.domain.entity.Product;
import br.com.produts.store.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/post")
    public ResponseEntity saveProduct(@RequestBody ProductsRequestDTO data){
        var product = productService.productSave(data);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Product>> listAll(){
        var listProducts = productService.listAllProducts();
        return ResponseEntity.ok().body(listProducts);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> listId(@PathVariable Long id){
        var list = productService.listProductId(id);
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody ProductsRequestDTO updateData){
        var updateProduct = productService.updateProduct(id, updateData);
        return ResponseEntity.ok().body(updateProduct);
    }
    @DeleteMapping( "/delete/{id}/")
    public ResponseEntity deleteId(@PathVariable Long id){
        productService.deleteProductId(id);
        return ResponseEntity.noContent().build();
    }

}
