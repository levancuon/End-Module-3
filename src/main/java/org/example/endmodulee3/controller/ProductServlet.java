package org.example.endmodulee3.controller;

import org.example.endmodulee3.model.Product;
import org.example.endmodulee3.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListProduct(req, resp);
                break;
            case "/insert":
                showFormInsert(req, resp);
                break;
            case "/delete":
                deleteProduct(req, resp);
                break;
            case "/update":
                showFormUpdate(req, resp);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        resp.sendRedirect("/product/list");
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
    }

    private void showFormInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/insert.jsp").forward(req, resp);
    }

    private void showListProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.selectProductAll();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/insert":
                insertProduct(req, resp);
                break;
        }
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) {
        String product_name = req.getParameter("product_name");
        String product_price = req.getParameter("product_price");
        String product_quantity = req.getParameter("product_quantity");
        String product_color = req.getParameter("product_color");
        String product_description = req.getParameter("product_description");
        String product_category = req.getParameter("product_category");
        Product product = new Product();
        product.setName(product_name);
        product.setPrice(Double.parseDouble(product_price));
        product.setQuantity(Integer.parseInt(product_quantity));
        product.setColor(product_color);
        product.setDescription(product_description);
        product.setCategory(product_category);
        productService.add(product);
        try {
            resp.sendRedirect("/product/list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
