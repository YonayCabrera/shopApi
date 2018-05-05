package shopApi.domains;

public class CustomerDTO {
    private String name;
    private String surname;
    private String image;

    public CustomerDTO(String name, String surname, String image) {

        this.name = name;
        this.surname = surname;
        this.image = image;
    }

    public CustomerDTO() {

    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getImage() {
        return image;
    }
}
