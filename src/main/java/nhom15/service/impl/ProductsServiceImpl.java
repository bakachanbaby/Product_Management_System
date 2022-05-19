package nhom15.service.impl;

import nhom15.entity.Products;
import nhom15.repository.ProductsRepository;
import nhom15.repository.ProductsRepository;
import nhom15.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Khai báo đây là service
@Service
public class ProductsServiceImpl implements ProductsService {

    //Khai báo giá trị Repository
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products saveProducts(Products Products) {
        return  productsRepository.save(Products);
    }

    @Override
    public Products getProductsById(int id) {
        return productsRepository.findById(id).get();
    }

    @Override
    public Products updateProducts(Products Products) {
        return productsRepository.save(Products);
    }

    @Override
    public void deleteProductsById(int id) {
        productsRepository.deleteById(id);
    }
}
