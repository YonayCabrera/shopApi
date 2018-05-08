package shopApi.domain;

public class CustomerDTO {
    private int id;
    private String name;
    private String surname;
    private String image;
    private String lastModification;
    private String createdBy;

    public CustomerDTO(int id,String name, String surname, String image, String lastChange, String createdBy) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.image = image;
        this.lastModification = lastChange;
        this.createdBy = createdBy;
    }

    public CustomerDTO() {

    }

    public int getId() {
        return id;
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

    public String getLastModification() {
        return lastModification;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastModification(String lastModification) {
        this.lastModification = lastModification;
    }
}
