package org.example.endmodulee3.service.product;

import org.example.endmodulee3.model.Product;
import org.example.endmodulee3.repository.product.ProductRepo;

import java.util.List;

public class ProductService implements IProductService{
    ProductRepo productRepo = new ProductRepo();


    @Override
    public List<Product> selectProductAll() {
      return productRepo.selectProductAll();
    }

    @Override
    public void add(Product product) {
        productRepo.add(product);
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }
}
