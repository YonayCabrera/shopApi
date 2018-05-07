package shopApi.domain;

public class UserDTO {
    private String name;
    private String password;
    private String email;
    private String role;
    private String key;

    public UserDTO(String name, String password, String email, String role, String key) {

        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.key = key;
    }

    public UserDTO(){
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

    public String getKey() {
        return key;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
