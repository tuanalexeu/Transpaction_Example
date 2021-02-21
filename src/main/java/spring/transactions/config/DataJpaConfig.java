package spring.transactions.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"spring.transactions.*"})
@EnableJpaRepositories
public class DataJpaConfig {
}
