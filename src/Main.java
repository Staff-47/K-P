import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Main {
    // Клас для реалізації CRUD операцій
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

    public static void main(String[] args) {
        // Створення основного вікна додатка
        JFrame frame = new JFrame("Проєкт");
        JMenuBar menuBar = new JMenuBar(); // Створюємо меню

        // Створення пункту меню "Файл"
        JMenu fileMenu = new JMenu("Файл");

        // Створюємо об'єкт TaskManager для виконання CRUD операцій
        TaskManager taskManager = new TaskManager();

        // Пункт меню "Вихід"
        JMenuItem exitItem = new JMenuItem("Вихід");
        exitItem.addActionListener(e -> System.exit(0)); // Завершення програми

        // Пункти меню CRUD операцій
        JMenuItem createItem = new JMenuItem("Створити");
        JMenuItem deleteItem = new JMenuItem("Видалити");
        JMenuItem readItem = new JMenuItem("Зчитати");
        JMenuItem updateItem = new JMenuItem("Оновити");
        JMenuItem showItems = new JMenuItem("Показати всі завдання");

        // Додаємо обробники подій для кожного пункту меню
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

        // Додаємо пункти меню до "Файл"
        fileMenu.add(createItem);
        fileMenu.add(deleteItem);
        fileMenu.add(readItem);
        fileMenu.add(updateItem);
        fileMenu.add(showItems);
        fileMenu.add(exitItem);

        // Додаємо меню до меню-бару
        menuBar.add(fileMenu);

        // Встановлюємо меню-бар для вікна
        frame.setJMenuBar(menuBar);

        // Налаштовуємо параметри вікна
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
