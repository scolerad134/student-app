package com.student.service;

import com.student.model.Student;

import java.util.List;

/**
 * API сервиса для работы с {@link Student}.
 */

public interface StudentService {

    /**
     * Получение списка студентов.
     *
     * @return список студентов
     */
    List<Student> getAllStudents();

    /**
     * Сохранение студента.
     */
    void addStudent(Student student);

    /**
     * Удаление студента по уникальному номеру.
     */
    void deleteStudent(String uniqueNumber);
}
