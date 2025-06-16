import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Створення основного вікна додатка
        JFrame frame = new JFrame("Проєкт");
        JMenuBar menuBar = new JMenuBar(); // Створюємо меню

        // Створення пункту меню "Файл"
        JMenu fileMenu = new JMenu("Файл");

        // Пункт меню "Вихід"
        JMenuItem exitItem = new JMenuItem("Вихід");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Завершення програми
            }
        });

        // Додаємо пункт меню "Вихід"
        fileMenu.add(exitItem);

        // Додаємо інші пункти меню
        JMenuItem createItem = new JMenuItem("Створити");
        JMenuItem deleteItem = new JMenuItem("Видалити");
        JMenuItem readItem = new JMenuItem("Зчитати");
        JMenuItem updateItem = new JMenuItem("Оновити");
        JMenuItem searchItem = new JMenuItem("Пошук");
        JMenuItem sortItem = new JMenuItem("Сортування");

        // Додаємо обробники подій для кожного пункту меню
        createItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Створення"));
        deleteItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Видалення"));
        readItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Зчитування"));
        updateItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Оновлення"));
        searchItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Пошук"));
        sortItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Сортування"));

        // Додаємо пункти меню до "Файл"
        fileMenu.add(createItem);
        fileMenu.add(deleteItem);
        fileMenu.add(readItem);
        fileMenu.add(updateItem);
        fileMenu.add(searchItem);
        fileMenu.add(sortItem);

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