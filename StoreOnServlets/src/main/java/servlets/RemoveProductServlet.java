package servlets;

import BaseOfData.ConnectionToProducts;
import BaseOfData.entitys.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nikk on 17.11.2015.
 */
@WebServlet("/delete")
public class RemoveProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.valueOf(req.getParameter("id"));
        ConnectionToProducts.remove(id);
        ArrayList<Product> arrayList = ConnectionToProducts.getProducts();
        req.getSession().setAttribute("Products", arrayList);
        resp.sendRedirect("/main");
    }
}
