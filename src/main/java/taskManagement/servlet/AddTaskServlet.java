package taskManagement.servlet;

import taskManagement.manager.TaskManager;
import taskManagement.manager.UserManager;
import taskManagement.model.Task;
import taskManagement.model.TaskStatus;
import taskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/AddTask")
public class AddTaskServlet extends HttpServlet {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private TaskManager taskManager = new TaskManager();
    private UserManager userManager = new UserManager();
    private Task task = new Task();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String taskName = req.getParameter("name");
        String desc = req.getParameter("desc");
        String userEmail = req.getParameter("userEmail");
        long id = userManager.getByEmail(userEmail).getId();
        String status = req.getParameter("status");
        String deadline = req.getParameter("deadline");
        task.setName(taskName);
        task.setDescription(desc);
        task.setId(id);
        task.setStatus(TaskStatus.valueOf(status));
        try {
            Date dead = sdf.parse(deadline);
            task.setDeadline(dead);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskManager.add(task);
        req.getRequestDispatcher("/WEB-INF/AddTask.jsp").forward(req, resp);

    }
}
