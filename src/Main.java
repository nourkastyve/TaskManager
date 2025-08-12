import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        scanner = new Scanner(System.in);
        while(true){
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice){
                case "1" -> taskManager.addTask();
                case "2" -> taskManager.deleteTask();
                case "3" -> taskManager.listTasks();
                case "4" -> taskManager.sortTasks();
                case "5" -> System.exit(0);
                default->
                    System.out.println("Invalid action, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== GESTIONNAIRE DE TÂCHES =====");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Supprimer une tâche");
        System.out.println("3. Lister les tâches");
        System.out.println("4. Trier les tâches par priorité");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");
    }
}