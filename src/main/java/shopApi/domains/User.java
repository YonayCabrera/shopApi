package shopApi.domains;

public class User {
    private final String name;
    private final String password;
    private final String email;

    public User(String name, String password, String email) {

        this.name = name;
        this.password = password;
        this.email = email;
    }
}
