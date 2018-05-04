package shopApi.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import shopApi.repositories.ShopRepository;
import shopApi.repositories.ShopRepositoryPostgreSql;

@Configuration
public class PersistenceConfiguration {
    @Value("jdbc:postgresql://localhost:5432/shoptheam")
    private String connection;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public ShopRepository dataSource(){
        return new ShopRepositoryPostgreSql(connection);
    }
}
