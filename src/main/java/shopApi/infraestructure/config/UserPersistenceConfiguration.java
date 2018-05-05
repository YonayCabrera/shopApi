package shopApi.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import shopApi.repositories.userRepository.UserRepository;
import shopApi.repositories.userRepository.UserRepositoryPostgreSql;

@Configuration
public class UserPersistenceConfiguration {
    @Value("jdbc:postgresql://localhost:5432/shoptheam")
    private String connection;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public UserRepository dataSource(){
        return new UserRepositoryPostgreSql(connection);
    }
}
