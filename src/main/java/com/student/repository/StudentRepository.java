package com.student.repository;

import com.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с Student.
 */
@Repository
public interface StudentRepository {

    /**
     * Метод для получения студентов.
     *
     * @return список студентов
     */
    List<Student> findAll();

    /**
     * Метод для добавления студента.
     *
     */
    int save(Student student);

    /**
     * Метод для удаления студента по уникальному номеру.
     *
     */
    int deleteStudentByUniqueNumber(String uniqueNumber);
}
