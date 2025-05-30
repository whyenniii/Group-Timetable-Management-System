package dbclass.grouptimetablemanagementsystem.user.repository;

import dbclass.grouptimetablemanagementsystem.user.User;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JdbcTemplateUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserRepository(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User save(final User user) {
        String sql = "INSERT INTO users (user_number, user_name) VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[]{"id"});
            System.out.println("save: " + user.getUserNumber());
            System.out.println("save: " + user.getUserName());
            pstmt.setInt(1, user.getUserNumber());
            pstmt.setString(2, user.getUserName());
            return pstmt;
        }, keyHolder);
        long key = keyHolder.getKey().longValue();
        System.out.println(key);
        user.setId(key);
        return user;
    }

    @Override
    public Optional<User> findByUserNumber(final int userNumber) {
        String sql = "SELECT * FROM users WHERE user_number = ?";

        try {
            User user = jdbcTemplate.queryForObject(sql, rowMapper(), userNumber);
            System.out.println("findByUserNumber: " + user.getUserNumber());
            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, rowMapper());
    }

    @Override
    public int update(final User user) {
        String sql = "UPDATE users SET user_number = ?, user_name = ? WHERE user_number= ?";
        return jdbcTemplate.update(sql, user.getUserNumber(), user.getUserName(), user.getId());
    }

    @Override
    public int deleteByUserNumber(final int userNumber) {
        String sql = "DELETE FROM users WHERE user_number = ?";
        return jdbcTemplate.update(sql, userNumber);
    }


    private RowMapper<User> rowMapper() {
        return (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getInt("user_number"),
                rs.getString("user_name")
        );
    }
}
