package dbclass.grouptimetablemanagementsystem.timetable;

import dbclass.grouptimetablemanagementsystem.timetable.repository.TimetableRepository;
import java.util.List;
import java.util.Optional;

public class TimetableService {

    private final TimetableRepository timetableRepository;
    public TimetableService(final TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    Timetable createTimetable(final Timetable timetable) {
        return timetableRepository.save(timetable);
    }


    List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    List<Timetable> getTimetableByStudentId(final int studentId) {
        return timetableRepository.findByStudentId(studentId);
    }

    Optional<Timetable> findTimetableByDay(final int studentId, final String day) {
        return timetableRepository.findByDay(studentId, day);
    }

    public int updateDay(final String day, final Timetable timetable) {
        return timetableRepository.updateDay(day, timetable);
    }

    public int updateTime(final Timetable timetable) {
        return timetableRepository.updateTime(timetable);
    }

    public int deleteTimetable(final int id) {
        return timetableRepository.delete(id);
    }

    public List<Timetable> findAllByDay(final String day) {
        return timetableRepository.findAllByday(day);
    }

    public Optional<Timetable> findTimetableByWeek(final int studentId, final int week) {
        return timetableRepository.findByWeek(studentId, week);
    }
}
