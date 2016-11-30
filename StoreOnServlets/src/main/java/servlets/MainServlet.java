package servlets;

import BaseOfData.ConnectionToProducts;
import BaseOfData.ConnectionToUsers;
import BaseOfData.entitys.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikk on 15.11.2015.
 */
@WebServlet(value = "/main", name = "Main")
public class MainServlet extends HttpServlet {
    boolean firstTime;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.getSession().setAttribute("Products", ConnectionToProducts.getProducts());
        RequestDispatcher requestDispatcher;
        Cookie cookies [] = req.getCookies();
        if (firstTime | cookies != null){
            String cookieName = "login";
            Cookie myCookie = null;
            String [] s = null;
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(cookieName)) {
                        myCookie = cookies[i];
                        s = myCookie.getValue().split(":");
                        break;
                    }
                }
            }
            if (s != null){
                if (ConnectionToUsers.loginUser(new User(s[0], s[1]))) {
                    req.getSession().setAttribute("logName", s[0]);
                    req.getSession().setAttribute("login", "true");
                }
                else {
                    req.getSession().setAttribute("login", null);
                }
            }
            firstTime = false;
            requestDispatcher = req.getRequestDispatcher("/WEB-INF/main.jsp");
        }
        else {
            requestDispatcher = req.getRequestDispatcher("/WEB-INF/main.jsp");
        }
        requestDispatcher.include(req, resp);
    }

    @Override
    public void init() throws ServletException {
        firstTime = true;
    }
}
