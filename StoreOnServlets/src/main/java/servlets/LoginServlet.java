package servlets;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nikk on 14.11.2015.
 */
@WebServlet(value = "/login", name = "Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        if (checkLogin(req.getParameter("login"))) {
            User user = new User(req.getParameter("login"), req.getParameter("password"));

            if (ConnectionToUsers.loginUser(user)) {
                String check = req.getParameter("remember");
                if (check != null){
                    Cookie loginCookie = new Cookie("login", user.getLogin() + ":" +  user.getPassword());
                    loginCookie.setMaxAge(60 * 60 * 24 * 365);
                    resp.addCookie(loginCookie);
                }
                req.getSession().setAttribute("login", "true");
                req.getSession().setAttribute("logName", user.getLogin());
                resp.sendRedirect("/main");
            } else {
                req.getSession().setAttribute("login", "false");
                resp.sendRedirect("/login");
            }
        }
        else {
            req.getSession().setAttribute("login", "wrong");
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String login = (String) request.getSession().getAttribute("login");
        RequestDispatcher requestDispatcher;
        if(login != null && login.equals("true")){
            response.sendRedirect("/main");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
            requestDispatcher.include(request, response);
        }

    }

    private boolean checkLogin(String login){
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
