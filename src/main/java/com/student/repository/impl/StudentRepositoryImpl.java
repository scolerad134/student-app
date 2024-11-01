package com.student.repository.impl;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Реализация {@link StudentRepository}.
 */
@Repository
@RequiredArgsConstructor
@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Возвращает список всех студентов.
     *
     * @return список объектов типа Student, представляющих всех студентов.
     */
    @Override
    public List<Student> findAll() {
        log.info("Find all students");
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Student(
            rs.getLong("id"),
            rs.getString("firstname"),
            rs.getString("lastname"),
            rs.getString("patronymic"),
            rs.getDate("date_of_birth").toLocalDate(),
            rs.getString("group_name"),
            rs.getString("unique_number")
        ));
    }

    /**
     * Сохраняет студента.
     */
    @Override
    public void save(Student student) {
        log.info("Save student {}", student);
        String sql = "INSERT INTO students" +
            "(firstname, lastname, patronymic, date_of_birth, group_name, unique_number)" +
            "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, student.getFirstName(),
            student.getLastName(), student.getPatronymic(),
            student.getDateOfBirth(), student.getGroupName(), student.getUniqueNumber());
    }

    /**
     * Удаляет студента по уникальному номеру.
     */
    @Override
    public void deleteStudentByUniqueNumber(String uniqueNumber) {
        log.info("Delete student with unique number {}", uniqueNumber);
        String sql = "DELETE FROM students WHERE unique_number = ?";
        jdbcTemplate.update(sql, uniqueNumber);
    }
}
