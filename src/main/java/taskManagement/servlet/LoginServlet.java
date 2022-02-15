package taskManagement.servlet;

import taskManagement.manager.UserManager;
import taskManagement.model.User;
import taskManagement.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getByEmailAndPassword(email, password);
        if (user != null) {
            if (user.getType() == UserType.MANAGER) {
                req.getRequestDispatcher("/ManagerHome").forward(req, resp);
            } else if (user.getType() == UserType.USER) {
                req.getRequestDispatcher("/UserHome").forward(req, resp);
            }
        }
    }

}
