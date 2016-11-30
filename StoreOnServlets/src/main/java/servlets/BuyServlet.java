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
 * Created by nikk on 29.11.2015.
 */
@WebServlet(name = "BuyServlet", value = "/buy")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        ArrayList<Product> arrayList = (ArrayList) req.getSession().getAttribute("bucket");
        int price = 0;
        for (int i = 0; i<arrayList.size(); i++){
            Product product = arrayList.get(i);
            price += Integer.valueOf(product.getPrice());
        }
        req.getSession().setAttribute("price", price);
        req.getSession().setAttribute("bucket", null);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/bucket.jsp");
        requestDispatcher.include(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.valueOf(req.getParameter("id"));
        Product product = ConnectionToProducts.getProduct(id);
        ArrayList<Product> arrayList;
        if (req.getSession().getAttribute("bucket") == null){
            arrayList = new ArrayList<Product>();
        }
        else {
            arrayList = (ArrayList) req.getSession().getAttribute("bucket");
        }
        arrayList.add(product);
        req.getSession().setAttribute("bucket", arrayList);
        resp.sendRedirect("/main");
    }

}
