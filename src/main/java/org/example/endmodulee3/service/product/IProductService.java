package org.example.endmodulee3.service.product;

import org.example.endmodulee3.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectProductAll();

    void add(Product product);

    void delete(int id);
}
