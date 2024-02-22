package br.com.produts.store.domain.service;

import br.com.produts.store.domain.dto.ProductsRequestDTO;
import br.com.produts.store.domain.entity.Product;
import br.com.produts.store.domain.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    // metado de cadastro
    public Product productSave(ProductsRequestDTO data){
        var productData = new Product(data);
        productRepository.save(productData);
        return productData;
    }

    //metado de listar todos
    public List<Product> listAllProducts(){
        List<Product> list = productRepository.findAll();
        return list;
    }

    //metado de listar por id
    public Product listProductId(Long id){
        var productList = productRepository.findById(id).get();
        return productList;
    }
    //metado de atualizar
    public Product updateProduct(Long id, ProductsRequestDTO data){
        Optional<Product> optionalProduct = productRepository.findById(id);
            if(optionalProduct.isPresent()){
                Product updateProduct = optionalProduct.get();

                if(data.name()!=null){
                    updateProduct.setName(data.name());
                }
                if(data.image()!=null){
                    updateProduct.setImage(data.image());
                }
                if(data.price()!=null){
                    updateProduct.setPrice(data.price());
                }
                if(data.description()!=null){
                    updateProduct.setDescription(data.description());
                }
                return updateProduct;
            } else {
                throw new EntityNotFoundException();
            }
    }

    //metado de deletar
    public void deleteProductId(Long id){
        Optional<Product> deleteProduct= productRepository.findById(id);
        if(deleteProduct.isPresent()){
            Product product = deleteProduct.get();
            productRepository.delete(product);
        }else {
            throw new EntityNotFoundException();
        }
    }
}
