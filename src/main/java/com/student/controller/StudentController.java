package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для работы с маппингом "/students".
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    /**
     * Получение списка всех студентов.
     *
     * @return List студентов
     */
    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        log.debug("GET-request, getAllStudents - start");
        List<Student> students = studentService.getAllStudents();
        log.debug("GET-request, getAllStudents - end");
        return ResponseEntity.ok(students);
    }

    /**
     * Добавление студента в список.
     *
     */
    @PostMapping()
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        log.debug("POST-request, addStudent - start, student = {}", student);
        studentService.addStudent(student);
        log.debug("POST-request, addStudent - end, student = {}", student);
        return ResponseEntity.ok("Student added successfully.");
    }

    /**
     * Удаление студента из списка.
     *
     */
    @DeleteMapping("/{uniqueNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable String uniqueNumber) {
        log.debug("POST-request, deleteStudent - start, uniqueNumber = {}", uniqueNumber);
        studentService.deleteStudent(uniqueNumber);
        log.debug("POST-request, deleteStudent - end, uniqueNumber = {}", uniqueNumber);
        return ResponseEntity.ok("Student deleted successfully.");
    }

}
