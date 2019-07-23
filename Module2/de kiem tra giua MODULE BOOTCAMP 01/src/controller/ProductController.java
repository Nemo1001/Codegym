package controller;

import Model.Product;
import service.ProductService;

public class ProductController {
ProductService productService = new ProductService();
public Product[] findAll() {
    {
        return productService.findAll();
    }
}
}
