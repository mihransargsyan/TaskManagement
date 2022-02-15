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

@WebServlet(urlPatterns = "/AddUser")
public class AddUserServlet extends HttpServlet {

    private User user = new User();
    private UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");
        user.setName(userName);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        user.setType(UserType.valueOf(userType));
        userManager.addUser(user);

        req.getRequestDispatcher("/WEB-INF/ManagerHome.jsp").forward(req, resp);

    }
}
