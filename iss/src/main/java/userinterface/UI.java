//package userinterface;
//
//import domeniu.Employee;
//import domeniu.Boss;
//import domeniu.Task;
//import service.EmployeeService;
//import service.BossService;
//import service.TaskService;
//
//import java.util.Scanner;
//
//public class UI {
//    private EmployeeService employeeService;
//    private TaskService taskService;
//    private BossService bossService;
//    private Scanner scanner;
//
//    public UI() {
//        this.employeeService = new EmployeeService();
//        this.taskService = new TaskService();
//        this.bossService = new BossService();
//        this.scanner = new Scanner(System.in);
//    }
//
//    public void meniu() {
//        boolean inMeniu = true;
//        while (inMeniu) {
//            System.out.println("1. Adaugă Angajat");
//            System.out.println("2. Găsește Angajat");
//            System.out.println("3. Actualizează Angajat");
//            System.out.println("4. Șterge Angajat");
//            System.out.println("5. Afișează toți Angajatii");
//            System.out.println("6. Adaugă Task");
//            System.out.println("7. Găsește Task");
//            System.out.println("8. Actualizează Task");
//            System.out.println("9. Șterge Task");
//            System.out.println("10. Afișează toate Task-urile");
//            System.out.println("11. Adaugă Șef");
//            System.out.println("12. Găsește Șef");
//            System.out.println("13. Actualizează Șef");
//            System.out.println("14. Șterge Șef");
//            System.out.println("15. Afișează toți Șefii");
//            System.out.println("0. Ieșire");
//
//            int optiune = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (optiune) {
//                case 1:
//                    AddEmployee();
//                    break;
//                case 2:
//                    FindEmployeeById();
//                    break;
//                case 3:
//                    UpdateEmployee();
//                    break;
//                case 4:
//                    DeleteEmployee();
//                    break;
//                case 5:
//                    GetAllEmployees();
//                    break;
//                case 6:
//                    AddTask();
//                    break;
//                case 7:
//                    FindTask();
//                    break;
//                case 8:
//                    UpdateTask();
//                    break;
//                case 9:
//                    DeleteTask();
//                    break;
//                case 10:
//                    GetAllTasks();
//                    break;
//                case 11:
//                    AddBoss();
//                    break;
//                case 12:
//                    FindBoss();
//                    break;
//                case 13:
//                    UpdateBoss();
//                    break;
//                case 14:
//                    DeteleBoss();
//                    break;
//                case 15:
//                    GetAllBosses();
//                    break;
//                case 0:
//                    inMeniu = false;
//                    break;
//                default:
//                    System.out.println("Opțiune invalidă!");
//            }
//        }
//    }
//
//    private void AddEmployee() {
//        System.out.println("Introduceti id-ul angajatului:");
//        int id = scanner.nextInt();
//
//        scanner.nextLine();
//        System.out.println("Introduceti numele angajatului:");
//        String name = scanner.nextLine();
//
//        scanner.nextLine();
//        System.out.println("Introduceti numele angajatului:");
//        String nume = scanner.nextLine();
//
//        Employee Employee = new Employee(id, nume);
//        employeeService.addEmployee(Employee);
//        System.out.println("Angajatul a fost adaugat cu succes.");
//    }
//
//    private void FindEmployeeById() {
//        System.out.println("Introduceti id-ul angajatului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Employee Employee = employeeService.findEmployeeById(id);
//        if (Employee != null) {
//            System.out.println("Angajatul gasit: " + Employee);
//        } else {
//            System.out.println("Angajatul nu a fost gasit.");
//        }
//    }
//
//    private void UpdateEmployee() {
//        System.out.println("Introduceti id-ul angajatului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Introduceti noul nume al angajatului:");
//        String nume = scanner.nextLine();
//
//        Employee Employee = new Employee(id, nume);
//        employeeService.updateEmployee(Employee);
//        System.out.println("Angajatul a fost actualizat cu succes.");
//    }
//
//    private void DeleteEmployee() {
//        System.out.println("Introduceti id-ul angajatului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Employee Employee = employeeService.findEmployeeById(id);
//        if (Employee != null) {
//            employeeService.deleteEmployee(Employee);
//            System.out.println("Angajatul a fost șters cu succes.");
//        } else {
//            System.out.println("Angajatul nu a fost gasit.");
//        }
//    }
//
//    private void GetAllEmployees() {
//        System.out.println("Lista angajatilor:");
//        for (Employee Employee : employeeService.getAngajati()) {
//            System.out.println(Employee);
//        }
//    }
//
//    private void AddTask() {
//        System.out.println("Introduceti id-ul Task-ului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Introduceti descrierea Task-ului:");
//        String descriere = scanner.nextLine();
//
//        Task task = new Task(id, descriere);
//        taskService.addTask(task);
//        System.out.println("Task-ul a fost adaugat cu succes.");
//    }
//
//    private void FindTask() {
//        System.out.println("Introduceti id-ul Task-ului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Task task = taskService.findTask(id);
//        if (task != null) {
//            System.out.println("Task-ul gasit: " + task);
//        } else {
//            System.out.println("Task-ul nu a fost gasit.");
//        }
//    }
//
//    private void UpdateTask() {
//        System.out.println("Introduceti id-ul Task-ului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Introduceti noua descriere a Task-ului:");
//        String descriere = scanner.nextLine();
//
//        Task task = new Task(id, descriere);
//        taskService.updateTask(task);
//        System.out.println("Task-ul a fost actualizat cu succes.");
//    }
//
//    private void DeleteTask() {
//        System.out.println("Introduceti id-ul Task-ului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Task task = taskService.findTask(id);
//        if (task != null) {
//            taskService.deleteTask(task);
//            System.out.println("Task-ul a fost șters cu succes.");
//        } else {
//            System.out.println("Task-ul nu a fost gasit.");
//        }
//    }
//
//    private void GetAllTasks() {
//        System.out.println("Lista Task-urilor:");
//        for (var task : taskService.getTasks()) {
//            System.out.println(task);
//        }
//    }
//
//    private void AddBoss() {
//        System.out.println("Introduceti id-ul șefului:");
//        int id = scanner.nextInt();
//
//        Boss Boss = new Boss(id);
//        bossService.addBoss(Boss);
//        System.out.println("Șeful a fost adaugat cu succes.");
//    }
//
//    private void FindBoss() {
//        System.out.println("Introduceti id-ul șefului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Boss Boss = bossService.findBossById(id);
//        if (Boss != null) {
//            System.out.println("Șeful gasit: " + Boss);
//        } else {
//            System.out.println("Șeful nu a fost gasit.");
//        }
//    }
//
//    private void UpdateBoss() {
//        System.out.println("Introduceti id-ul șefului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Boss Boss = new Boss(id);
//        bossService.updateBoss(Boss);
//        System.out.println("Șeful a fost actualizat cu succes.");
//    }
//
//    private void DeteleBoss() {
//        System.out.println("Introduceti id-ul șefului:");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Boss Boss = bossService.findBossById(id);
//        if (Boss != null) {
//            bossService.deleteBoss(Boss);
//            System.out.println("Șeful a fost șters cu succes.");
//        } else {
//            System.out.println("Șeful nu a fost gasit.");
//        }
//    }
//
//    private void GetAllBosses() {
//        System.out.println("Lista șefilor:");
//        for (Boss Boss : bossService.getAllBosses()) {
//            System.out.println(Boss);
//        }
//    }
//}