package shopApi.domain;

public class User {
    private int id;
    private final String name;
    private final String password;
    private final String email;
    private final Roles role;

    public User(int id, String name, String password, String email, Roles role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Roles getRole() {
        return role;
    }
}
