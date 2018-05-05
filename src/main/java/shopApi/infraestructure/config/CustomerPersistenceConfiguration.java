package shopApi.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopApi.repositories.customerRepository.CustomerRepository;
import shopApi.repositories.customerRepository.CustomerRepositoryPostgreSql;
import shopApi.repositories.userRepository.UserRepository;
import shopApi.repositories.userRepository.UserRepositoryPostgreSql;

@Configuration
public class CustomerPersistenceConfiguration {
    @Value("${spring.datasource.url}")
    private String connection;

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryPostgreSql(connection);
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryPostgreSql(connection);
    }
}
