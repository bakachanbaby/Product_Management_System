package nhom15.service;

import nhom15.entity.Products;
import org.springframework.stereotype.Service;

import java.util.List;

//Khai báo đây là service
@Service
public interface ProductsService {
    //Lấy toàn bộ Products
    List<Products> getAllProducts();

    //Lưu thông tin Products
    Products saveProducts(Products Products);

    //Lấy thông tin Products theo id
    Products getProductsById(int id);

    //Cập nhật thông tin Products
    Products updateProducts(Products Products);

    //Thực hiện xóa Products theo id
    void deleteProductsById(int id);

}
