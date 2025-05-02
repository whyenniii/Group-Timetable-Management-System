package dbclass.grouptimetablemanagementsystem.timetable.repository.jdbctemplate;
import dbclass.grouptimetablemanagementsystem.timetable.Timetable;
import dbclass.grouptimetablemanagementsystem.timetable.repository.TimetableRepository;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JdbcTemplateTimetableRepository implements TimetableRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateTimetableRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTimetableRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Timetable save(final Timetable timetable) {
        String sql = "INSERT INTO timetable (day , start_time, end_time, student_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, timetable.getDay());
            ps.setInt(2, timetable.getStartTime());
            ps.setInt(3, timetable.getEndTime());
            ps.setInt(4, timetable.getStudentId());
            return ps;
        }, keyHolder);

        long key = keyHolder.getKey().longValue();
        log.debug("key: {}", key);
        timetable.setId(key);
        return timetable;
    }

    @Override
    public List<Timetable> findByStudentId(final int studentId) {
        String sql = "SELECT * FROM timetable WHERE student_id = ?";
        return jdbcTemplate.query(sql, rowMapper(), studentId);
    }

    @Override
    public Optional<Timetable> findByDay(final int studentId, final String day) {
        String sql = "SELECT * FROM timetable WHERE student_id = ? AND day = ?";
        Timetable timetable = jdbcTemplate.queryForObject(sql, rowMapper(), studentId, day);
        return Optional.of(timetable);
    }

    @Override
    public List<Timetable> findAll() {
        String sql = "SELECT * FROM timetable";
        List<Timetable> timetableList = jdbcTemplate.query(sql, rowMapper());
        log.debug("timetableList: {}", timetableList);
        return jdbcTemplate.query(sql, rowMapper());
    }


    @Override
    public int updateDay(final String day, final Timetable timetable) {
        String sql = "UPDATE timetable SET day = ? WHERE day = ?";
        return jdbcTemplate.update(sql, timetable.getDay(), day);
    }

    @Override
    public int updateTime(final Timetable timetable) {
        String sql = "UPDATE timetable SET start_time = ? , end_time = ? WHERE student_id = ?";
        return jdbcTemplate.update(sql, timetable.getStartTime(), timetable.getEndTime(), timetable.getStudentId());
    }

    @Override
    public int delete(final int id) {
        String sql = "DELETE FROM timetable WHERE student_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Timetable> findAllByday(final String day) {
        String sql = "SELECT * FROM timetable WHERE day = ?";
        return jdbcTemplate.query(sql, rowMapper(), day);
    }

    private RowMapper<Timetable> rowMapper() {
        return (rs, rowNum) -> new Timetable(
                rs.getLong("id"),
                rs.getString("day"),
                rs.getInt("start_time"),
                rs.getInt("end_time"),
                rs.getInt("student_id")
        );
    }
}
