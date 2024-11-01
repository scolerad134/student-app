package com.student.service.impl;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Реализация {@link StudentService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        log.debug("findAll - start");
        List<Student> students = studentRepository.findAll();
        log.info("findAll - end");
        return students;
    }

    @Override
    public void addStudent(Student student) {
        log.debug("save - start, student = {}", student);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String uniqueNumber) {
        log.debug("deleteStudentByUniqueNumber - start, uniqueNumber = {}", uniqueNumber);
        studentRepository.deleteStudentByUniqueNumber(uniqueNumber);
    }
}
