package shopApi.repositories;

import org.sql2o.Sql2o;

public class ShopRepositoryPostgreSql implements ShopRepository {

    private final Sql2o sql2o;
    public ShopRepositoryPostgreSql(String connection) {
        this.sql2o = sql2o(connection);
    }

    private Sql2o sql2o(String connectionUrl) {
        return new Sql2o(connectionUrl, "batman", "alfred");
    }

    @Override
    public void getAllCustomers() {

    }
}
