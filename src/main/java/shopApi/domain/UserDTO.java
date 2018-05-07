package shopApi.domain;

public class UserDTO {
    private int id;
    private String name;
    private String password;
    private String email;
    private String role;
    private String token;

    public UserDTO(int id,String name, String password, String email, String role, String token) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
