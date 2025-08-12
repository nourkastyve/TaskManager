import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private static final List<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private  static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static void addTask(){
        System.out.println("Give a description of the stain.");
        String description = scanner.nextLine();
        Priority priority = getPriority();
        LocalDate dueDate = getDueDate();

        tasks.add(new Task(description, priority, dueDate));
        System.out.println("task successfully added ");
    }
    public static void deleteTask(){
        System.out.println("remove a stain");
        if (tasks.isEmpty()){
            System.out.println("Aucune tache a supprimer");
            return;
        }
        listTasks();
        System.out.println("Give the number of the stain");
        try{
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if(index >= 0 && index < tasks.size() ){
                Task remove = tasks.remove(index);
                System.out.println("this task is Remove "+ remove.getDescription());
            }else{
                System.out.println("the number of the stain is not includ or invalid");
            }
        }catch (NumberFormatException e){
            System.out.println("Please enter a valid number");
        }
    }
    public static void listTasks(){
        if (tasks.isEmpty()){
            System.out.println("No stains are present");
        }
        System.out.println("the stains present are : ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
        }
    }
    //Trie de la liste
    public static void sortTasks(){
        if (tasks.isEmpty()){
            System.out.println("Aucune tache a trier");
            return;
        }
    }
    public static Priority getPriority(){
        while (true){
            try{
                System.out.println("Priority (HAUTE, MOYENNE, BASSE) :");
                return Priority.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Error : invalid priority : HAUTE, MOYENNE, BASSE");
            }
        }
    }

    public static LocalDate getDueDate(){
        while (true){
            try{
                System.out.println("Insert au format jj/mm/aaaa");
                String dateInput = scanner.nextLine();
                return dateInput.isBlank() ? null : LocalDate.parse(dateInput, DATE_FORMATTER);
            }catch (DateTimeParseException e){
                System.out.println("Format de date invalide : jj/mm/aaaa");
            }
        }
    }

}
