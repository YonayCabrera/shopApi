package shopApi.domain;

public enum Roles {
    ADMIN("admin"),
    USER("user");

    private String value;

    Roles(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

