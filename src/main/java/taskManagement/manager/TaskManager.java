package taskManagement.manager;

import taskManagement.db.DBConnectionProvider;
import taskManagement.model.Task;
import taskManagement.model.TaskStatus;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private UserManager userManager = new UserManager();

    public boolean add(Task task) {
        String sql = "INSERT INTO task(name,description,status,deadline,user_id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getStatus().name());
            statement.setString(4, sdf.format(task.getDeadline()));
            statement.setLong(5, task.getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                task.setId(rs.getLong(1));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Task> getAllTasksById(long id) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM task WHERE user_id =" + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tasks.add(getTaskFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    private Task getTaskFromResultSet(ResultSet resultSet) {
        try {
            return Task.builder()
                    .id(resultSet.getLong(1))
                    .name(resultSet.getString(2))
                    .description(resultSet.getString(3))
                    .status(TaskStatus.valueOf(resultSet.getString(4)))
                    .deadline(resultSet.getString(5) == null ? null : sdf.parse(resultSet.getString(5)))
                    .user(userManager.getById(resultSet.getLong(6)))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
