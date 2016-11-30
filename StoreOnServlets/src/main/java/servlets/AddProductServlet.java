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

@WebServlet(value = "/add", name = "AddProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        if (checkData(req.getParameter("pet"), req.getParameter("type"), req.getParameter("nameOfProduct"),
                req.getParameter("description"), req.getParameter("price"))) {
            Product product = new Product(req.getParameter("pet"), req.getParameter("type"), req.getParameter("nameOfProduct"),
                    req.getParameter("description"), req.getParameter("price"), req.getParameter("image"));

            if (ConnectionToProducts.add(product)) {
                req.getSession().setAttribute("log", "true");

            } else {
                req.getSession().setAttribute("log", "false");
            }
        }
        else {
            req.getSession().setAttribute("log", "wrong");

        }
        resp.sendRedirect("/add");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher requestDispatcher;
        String name = (String) request.getSession().getAttribute("logName");
        if (name != null && name.equals("Admin")) {
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/addProduct.jsp");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
        }
        requestDispatcher.include(request, response);
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
