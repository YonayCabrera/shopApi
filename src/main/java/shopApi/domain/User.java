package shopApi.domain;

public class User {
    private String role;
    private String token;
    private int id;
    private final String name;
    private final String password;
    private final String email;


    public User(int id, String name, String password, String email, String role, String token) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.token = token;
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

    public String getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }

    public UserDTO toDTO() {
        return new UserDTO(id,name,password,email,role, token);
    }
}
