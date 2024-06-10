package org.example.endmodulee3.repository.product;

import org.example.endmodulee3.database.ConnectDB;
import org.example.endmodulee3.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo{
    Connection connection = new ConnectDB().getConnection();
    @Override
    public List<Product> selectProductAll() {
        List<Product> productList = new ArrayList<>();
        String sql = "select * from product";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("product_price"));
                product.setQuantity(rs.getInt("product_quantity"));
                product.setColor(rs.getString("product_color"));
                product.setDescription(rs.getString("product_description"));
                product.setCategory(rs.getString("product_category"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }

    @Override
    public void add(Product product) {
        try {
        String sql = "insert into product(product_name,product_price,product_quantity,product_color,product_description,product_category) value (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1,product.getName());
           ps.setDouble(2,product.getPrice());
           ps.setInt(3,product.getQuantity());
           ps.setString(4,product.getColor());
           ps.setString(5,product.getDescription());
           ps.setString(6,product.getCategory());
           ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from product where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
