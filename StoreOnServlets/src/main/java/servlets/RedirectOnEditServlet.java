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

/**
 * Created by nikk on 18.11.2015.
 */
@WebServlet("/editProd")
public class RedirectOnEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = (String) request.getSession().getAttribute("logName");
        if (name != null && name.equals("Admin")) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            Product product = ConnectionToProducts.getProduct(id);
            request.getSession().setAttribute("editProduct", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/editProduct.jsp");
            requestDispatcher.include(request, response);
        }
        else {
            response.sendRedirect("/main");
        }
    }
}
