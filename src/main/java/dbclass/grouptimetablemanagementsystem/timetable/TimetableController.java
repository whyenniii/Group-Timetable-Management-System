package dbclass.grouptimetablemanagementsystem.timetable;

import java.sql.Time;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timetables")
public class TimetableController {

    private final TimetableService timetableService;
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    //시간표 추가
    @PostMapping
    public ResponseEntity<Timetable> createTimetable(@RequestBody final TimetableRequest request) {
        Timetable timetable = new Timetable(request.getDay(), request.getStartTime(), request.getEndTime(), request.getStudentId());
        return ResponseEntity.ok(timetableService.createTimetable(timetable));
    }

    @GetMapping
    public ResponseEntity<List<Timetable>> getAllTimetables() {
        return ResponseEntity.ok(timetableService.findAll());
    }

    //특정 학생 시간표 불러오기
    @GetMapping("/{id}")
    public ResponseEntity<List<Timetable>> getTimetable(@PathVariable("id") final int id) {
        return ResponseEntity.ok(timetableService.getTimetableByStudentId(id));
    }

    //특정 학생 특정 요일 시간표 불러오기
    @GetMapping("/{id}/search")
    public ResponseEntity<Timetable> searchTimetable(@PathVariable("id") final int id, @RequestParam("day") final String day) {
        Timetable timetable = timetableService.findTimetableByDay(id, day).get();
        return ResponseEntity.ok(timetable);
    }

    //특정 요일 시간표 조회
    @GetMapping("/search")
    public ResponseEntity<List<Timetable>> searchTimetableByDay(@RequestParam("day") final String day) {
        return ResponseEntity.ok(timetableService.findAllByDay(day));

    }

    //특정 학생 특정 요일 수정
    @PatchMapping("/{id}/search")
    public ResponseEntity<Integer> updateDay(@PathVariable("id") final int studentId, @RequestParam("day") final String day, @RequestBody final TimetableRequest request) {
        Timetable timetable = new Timetable(request.getDay(), request.getStartTime(), request.getEndTime(), studentId);
        return ResponseEntity.ok(timetableService.updateDay(day, timetable));
    }

    //특정 학생 시간 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Integer> updateTime(@PathVariable("id") final int studentId, @RequestBody final TimetableRequest request) {
        Timetable timetable = new Timetable(request.getDay(), request.getStartTime(), request.getEndTime(), studentId);
        System.out.println(timetable.getDay());
        System.out.println(timetable.getStartTime());
        System.out.println(timetable.getEndTime());
        System.out.println(timetable.getStudentId());
        return ResponseEntity.ok(timetableService.updateTime(timetable));
    }

    //특정 학생 시간표 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTimetable(@PathVariable("id") final int id) {
        timetableService.deleteTimetable(id);
        return ResponseEntity.ok("고객 정보 삭제 성공");
    }



}
