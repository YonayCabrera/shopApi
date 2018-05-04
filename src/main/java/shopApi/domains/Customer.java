package shopApi.domains;

public class Customer {
    private final int id;
    private final String name;
    private final String surname;
    private final String image;

    public Customer(int id, String name, String surname, String image) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.image = image;
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

    public int getId() {
        return id;
    }
}
