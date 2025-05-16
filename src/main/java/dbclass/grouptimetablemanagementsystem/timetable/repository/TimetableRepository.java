package dbclass.grouptimetablemanagementsystem.timetable.repository;

import dbclass.grouptimetablemanagementsystem.timetable.Timetable;
import java.util.List;
import java.util.Optional;

public interface TimetableRepository {
    Timetable save(final Timetable timetable);

    List<Timetable> findByStudentId(final int studentId);

    List<Timetable> findAll();

    Optional<Timetable> findByDay(final int studentId, final String day);

    int updateDay(final String day, final Timetable timetable);

    int updateTime(final Timetable timetable);

    int delete(final int id);

    List<Timetable> findAllByday(String day);

    Optional<Timetable> findByWeek(final int studentId, final int week);
}
