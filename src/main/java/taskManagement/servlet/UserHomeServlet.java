package taskManagement.servlet;

import taskManagement.manager.TaskManager;
import taskManagement.manager.UserManager;
import taskManagement.model.Task;
import taskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/UserHome")
public class UserHomeServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();
    private UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        User user = userManager.getByEmail(email);
        long id = user.getId();
        List<Task> allTasksById = taskManager.getAllTasksById(id);
        req.setAttribute("tasks", allTasksById);
        req.getRequestDispatcher("/WEB-INF/UserHome.jsp").forward(req, resp);

    }
}
