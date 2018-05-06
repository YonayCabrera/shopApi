package shopApi.domains;

public class UserDTO {
    private final String name;
    private String password;
    private final String email;
    private String role;

    public UserDTO(String name, String password, String email, String role) {

        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
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

    public void setPassword(String password){
        this.password = password;
    }

}
