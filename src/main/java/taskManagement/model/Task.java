package taskManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task {
    private long id;
    private String name;
    private String description;
    private TaskStatus status;
    private Date deadline;
    private User user;
}
