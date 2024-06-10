package org.example.endmodulee3.repository.product;

import org.example.endmodulee3.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> selectProductAll();

    void add(Product product);

    void delete(int id);
}
