package shopApi.domain;

public class CustomerDTO {
    private int id;
    private String name;
    private String surname;
    private String image;
    private String lastModification;

    public CustomerDTO(int id,String name, String surname, String image, String lastChange) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.image = image;
        this.lastModification = lastChange;
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
