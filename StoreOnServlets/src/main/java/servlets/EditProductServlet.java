package servlets;

import BaseOfData.ConnectionToProducts;
import BaseOfData.entitys.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nikk on 28.11.2015.
 */
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        if (checkData(req.getParameter("pet"), req.getParameter("type"), req.getParameter("nameOfProduct"),
                req.getParameter("description"), req.getParameter("price"))) {
            Product id = (Product)req.getSession().getAttribute("editProduct");
            Product product = new Product(req.getParameter("pet"), req.getParameter("type"), req.getParameter("nameOfProduct"),
                    req.getParameter("description"), req.getParameter("price"), id.getId(), req.getParameter("image"));


            if (ConnectionToProducts.update(product)) {
                req.getSession().setAttribute("log", "true");
                ArrayList<Product> arrayList = ConnectionToProducts.getProducts();
                req.getSession().setAttribute("Products", arrayList);
                req.getSession().setAttribute("editProduct", product);

            } else {
                req.getSession().setAttribute("log", "false");
            }
        }
        else {
            req.getSession().setAttribute("log", "wrong");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/editProduct.jsp");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/main.jsp");
        requestDispatcher.include(req, resp);
    }

    private boolean checkData(String pet, String typeOfProduct, String nameOfProduct, String description, String price){
        if(pet != null && typeOfProduct != null && nameOfProduct != null && description != null){
            if (price == null) {
                return false;
            }
            else {
                return price.matches("^-?\\d+$");
            }
        }
        else {
            return false;
        }
    }
}
