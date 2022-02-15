package taskManagement.servlet;

import taskManagement.manager.UserManager;
import taskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/ManagerHome")
public class ManagerHomeServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> allUsers = userManager.getAllUsers();
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("/WEB-INF/ManagerHome.jsp").forward(req, resp);

    }
}
