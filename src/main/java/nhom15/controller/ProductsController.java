package nhom15.controller;

import nhom15.entity.Products;
import nhom15.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//Khai báo đây là controller
@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    //Chuyển đến trang list Products
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productsService.getAllProducts());
        return "products";
    }

    //Chuyển đến trang add Products
    @GetMapping("/products/new")
    public String createProductsForm(Model model) {

        Products products = new Products();
        model.addAttribute("Products", products);
        return "form-Products";
    }

    //Chuyển đến trang update Products
    @GetMapping("/products/edit/{id}")
    public String editProducts(@PathVariable int id,
                               Model model) {
        model.addAttribute("Products", productsService.getProductsById(id));
        model.addAttribute("edit", true);
        model.addAttribute("idProduct", id);
        return "form-Products";
    }

    //Thực hiện lưu thông tin Products
    @PostMapping("/products")
    public String saveProducts(@ModelAttribute("Products") Products Products) {

        productsService.saveProducts(Products);
        return "redirect:/products";
    }

    //Update Products
    @PostMapping("/products/{id}")
    public String updateProducts(@PathVariable int id,
                                 @ModelAttribute("Products") Products Products) {

        //Lấy thông tin Products đã cập nhật
        Products existingProducts = productsService.getProductsById(id);
        existingProducts.setCode(Products.getCode());
        existingProducts.setDescription(Products.getDescription());
        existingProducts.setPrice(Products.getPrice());

        //Lưu thông tin Products
        productsService.updateProducts(existingProducts);
        return "redirect:/products";
    }

    //Nhấn nút xóa Products để xóa
    @GetMapping("/products/delete/{id}")
    public String deleteProducts(@PathVariable int id) {
        productsService.deleteProductsById(id);
        return "redirect:/products";
    }
}
