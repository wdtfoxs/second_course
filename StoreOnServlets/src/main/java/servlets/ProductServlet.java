package servlets;

import BaseOfData.ConnectionToComments;
import BaseOfData.ConnectionToProducts;
import BaseOfData.entitys.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikk on 29.11.2015.
 */
@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.valueOf(req.getParameter("id"));
        Product product = ConnectionToProducts.getProduct(id);
        req.getSession().setAttribute("product", product);
        req.getSession().setAttribute("comments", ConnectionToComments.getComments(id));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/product.jsp");
        requestDispatcher.include(req, resp);
    }
}
