package dbclass.grouptimetablemanagementsystem.config;

import dbclass.grouptimetablemanagementsystem.user.UserRepository;
import dbclass.grouptimetablemanagementsystem.user.repository.JdbcTemplateUserRepository;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcTemplateConfig {
    private final DataSource dataSource;

    public JdbcTemplateConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserRepository userRepository() {
        return new JdbcTemplateUserRepository(dataSource);
    }


}
