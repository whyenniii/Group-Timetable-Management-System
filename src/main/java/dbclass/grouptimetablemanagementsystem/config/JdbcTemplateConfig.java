package dbclass.grouptimetablemanagementsystem.config;

import dbclass.grouptimetablemanagementsystem.timetable.TimetableService;
import dbclass.grouptimetablemanagementsystem.timetable.repository.TimetableRepository;
import dbclass.grouptimetablemanagementsystem.timetable.repository.jdbctemplate.JdbcTemplateTimetableRepository;
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

    @Bean
    public TimetableRepository timetableRepository() {
        return new JdbcTemplateTimetableRepository(dataSource);
    }

    @Bean
    public TimetableService timetableService() {
        return new TimetableService(timetableRepository());
    }

}
