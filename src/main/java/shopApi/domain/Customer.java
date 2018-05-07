package shopApi.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(image, customer.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, image);
    }

    public CustomerDTO toDTO() {
        return new CustomerDTO(id,name,surname,image);
    }
}
