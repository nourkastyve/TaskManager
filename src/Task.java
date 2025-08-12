import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String description;
    private Priority priority;
    private final LocalDate dueDate;
    private final LocalDate creationDate;
    private  static final  DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Task(String description, Priority priority, LocalDate dueDate){
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.creationDate = LocalDate.now();
    }



    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        String dueInfo = (dueDate != null) ? ("Echeance :" + dueDate.format(DATE_FORMATTER) ): "";
        return "Task{" +
                "description='" + description + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", creationDate=" + creationDate.format(DATE_FORMATTER) +
                '}';
    }
}
