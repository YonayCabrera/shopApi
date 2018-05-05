package shopApi.domains;

public class UserDTO {
    private final String name;
    private String password;
    private final String email;

    public UserDTO(String name, String password, String email) {

        this.name = name;
        this.password = password;
        this.email = email;
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

    public void setPassword(String password){
        this.password = password;
    }
}
