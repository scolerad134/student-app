package com.student.repository;

import com.student.model.Student;

import java.util.List;

/**
 * Репозиторий для работы с Student.
 */
public interface StudentRepository {

    /**
     * Метод для получения студентов.
     *
     * @return список студентов
     */
    List<Student> findAll();

    /**
     * Метод для добавления студента.
     */
    void save(Student student);

    /**
     * Метод для удаления студента по уникальному номеру.
     */
    void deleteStudentByUniqueNumber(String uniqueNumber);
}
