package servlets;



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
@WebServlet(name = "BucketServlet", value = "/bucket")
public class BucketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/bucket.jsp");
        requestDispatcher.include(req, resp);
    }

}
