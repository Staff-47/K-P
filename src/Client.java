import java.time.LocalDateTime;

public class Client {
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