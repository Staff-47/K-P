import java.time.LocalDateTime;

public class Task {
    private String name;
    private String description;
    private LocalDateTime dueDate;

    // Конструктор
    public Task(String name, String description, LocalDateTime dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    // Гетери для кожного поля
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    // Метод toString для виведення інформації про завдання
    @Override
    public String toString() {
        return "Завдання: " + name + "\nОпис: " + description + "\nДата виконання: " + dueDate;
    }
}

