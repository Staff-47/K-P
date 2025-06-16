import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Main {
    // Клас для реалізації CRUD операцій для завдань
    static class TaskManager {
        private List<String> tasks = new ArrayList<>();

        // Операція Create (створення)
        public void createTask(String task) {
            tasks.add(task);
        }

        // Операція Read (зчитування)
        public String readTask(int index) {
            if (index >= 0 && index < tasks.size()) {
                return tasks.get(index);
            } else {
                return "Завдання не знайдено!";
            }
        }

        // Операція Update (оновлення)
        public void updateTask(int index, String newTask) {
            if (index >= 0 && index < tasks.size()) {
                tasks.set(index, newTask);
            } else {
                System.out.println("Завдання не знайдено!");
            }
        }

        // Операція Delete (видалення)
        public void deleteTask(int index) {
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
            } else {
                System.out.println("Завдання не знайдено!");
            }
        }

        // Показати всі завдання
        public List<String> getAllTasks() {
            return tasks;
        }
    }

    // Клас для реалізації клієнтів
    static class Client {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDateTime becomeClientAt;

        public Client(int id, String firstName, String lastName, String email, LocalDateTime becomeClientAt) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.becomeClientAt = becomeClientAt;
        }

        // Гетери
        public int getId() { return id; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
        public LocalDateTime getBecomeClientAt() { return becomeClientAt; }

        @Override
        public String toString() {
            return "Client{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "', becomeClientAt=" + becomeClientAt + '}';
        }
    }

    // Клас для реалізації сортування клієнтів
    static class ClientComparators {

        // Сортування по імені
        public static Comparator<Client> sortByFirstName = new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getFirstName().compareTo(c2.getFirstName());
            }
        };

        // Сортування по даті приєднання до компанії
        public static Comparator<Client> sortByDate = new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getBecomeClientAt().compareTo(c2.getBecomeClientAt());
            }
        };
    }

    public static void main(String[] args) {
        // Створення основного вікна додатка
        JFrame frame = new JFrame("Проєкт");
        JMenuBar menuBar = new JMenuBar(); // Створюємо меню

        // Створюємо об'єкт TaskManager для виконання CRUD операцій для завдань
        TaskManager taskManager = new TaskManager();

        // Створюємо список клієнтів для сортування
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Clark", "Kent", "kent@email.com", LocalDateTime.of(2000, 2, 2, 2, 2)));
        clients.add(new Client(2, "Peter", "Parker", "parker@email.com", LocalDateTime.of(1990, 1, 1, 1, 1)));

        // Створення пункту меню "Файл"
        JMenu fileMenu = new JMenu("Файл");

        // Пункт меню "Вихід"
        JMenuItem exitItem = new JMenuItem("Вихід");
        exitItem.addActionListener(e -> System.exit(0)); // Завершення програми

        // Пункти меню CRUD операцій для завдань
        JMenuItem createItem = new JMenuItem("Створити завдання");
        JMenuItem deleteItem = new JMenuItem("Видалити завдання");
        JMenuItem readItem = new JMenuItem("Зчитати завдання");
        JMenuItem updateItem = new JMenuItem("Оновити завдання");
        JMenuItem showItems = new JMenuItem("Показати всі завдання");

        // Пункти меню для сортування клієнтів
        JMenuItem sortByName = new JMenuItem("Сортувати за іменем");
        JMenuItem sortByDate = new JMenuItem("Сортувати за датою приєднання");

        // Додаємо обробники подій для кожного пункту меню (CRUD)
        createItem.addActionListener(e -> {
            String task = JOptionPane.showInputDialog(frame, "Введіть нове завдання:");
            if (task != null && !task.isEmpty()) {
                taskManager.createTask(task);
                JOptionPane.showMessageDialog(frame, "Завдання створено!");
            }
        });

        readItem.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Введіть індекс завдання для перегляду:");
            try {
                int index = Integer.parseInt(input);
                String task = taskManager.readTask(index);
                JOptionPane.showMessageDialog(frame, "Завдання: " + task);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Невірний індекс!");
            }
        });

        updateItem.addActionListener(e -> {
            String indexInput = JOptionPane.showInputDialog(frame, "Введіть індекс завдання для оновлення:");
            try {
                int index = Integer.parseInt(indexInput);
                String newTask = JOptionPane.showInputDialog(frame, "Введіть нове завдання:");
                taskManager.updateTask(index, newTask);
                JOptionPane.showMessageDialog(frame, "Завдання оновлено!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Невірний індекс!");
            }
        });

        deleteItem.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Введіть індекс завдання для видалення:");
            try {
                int index = Integer.parseInt(input);
                taskManager.deleteTask(index);
                JOptionPane.showMessageDialog(frame, "Завдання видалено!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Невірний індекс!");
            }
        });

        showItems.addActionListener(e -> {
            List<String> tasks = taskManager.getAllTasks();
            StringBuilder taskList = new StringBuilder();
            for (String task : tasks) {
                taskList.append(task).append("\n");
            }
            JOptionPane.showMessageDialog(frame, taskList.toString());
        });

        // Додаємо обробники для сортування клієнтів
        sortByName.addActionListener(e -> {
            Collections.sort(clients, ClientComparators.sortByFirstName);
            JOptionPane.showMessageDialog(frame, "Клієнти відсортовані за іменем!");
        });
        sortByName.addActionListener(e -> {
            Collections.sort(clients, ClientComparators.sortByFirstName);
            StringBuilder sortedClients = new StringBuilder();
            for (Client client : clients) {
                sortedClients.append(client.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, "Клієнти відсортовані за іменем:\n" + sortedClients.toString());
        });

        sortByDate.addActionListener(e -> {
            Collections.sort(clients, ClientComparators.sortByDate);
            StringBuilder sortedClients = new StringBuilder();
            for (Client client : clients) {
                sortedClients.append(client.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, "Клієнти відсортовані за датою приєднання:\n" + sortedClients.toString());
        });
        sortByDate.addActionListener(e -> {
            Collections.sort(clients, ClientComparators.sortByDate);
            JOptionPane.showMessageDialog(frame, "Клієнти відсортовані за датою приєднання!");
        });

        // Додаємо пункти меню до "Файл"
        fileMenu.add(createItem);
        fileMenu.add(deleteItem);
        fileMenu.add(readItem);
        fileMenu.add(updateItem);
        fileMenu.add(showItems);
        fileMenu.add(sortByName);
        fileMenu.add(sortByDate);
        fileMenu.add(exitItem);

        // Додаємо меню до меню-бару
        menuBar.add(fileMenu);

        // Встановлюємо меню-бар для вікна
        frame.setJMenuBar(menuBar);

        // Налаштовуємо параметри вікна
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

