package servlets;

import BaseOfData.ConnectionToComments;
import BaseOfData.ConnectionToProducts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikk on 30.11.2015.
 */
@WebServlet(name = "CommentServlet", value = "/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("login");
        String comment = req.getParameter("comment");
        ConnectionToComments.addComment(name, id, comment);
        req.getSession().setAttribute("comments", ConnectionToComments.getComments(id));
        resp.sendRedirect("/product?id=" + id);
    }

}
