package com.student.service;

import com.student.model.Student;
import org.springframework.stereotype.Service;

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
    List<Student> findAll();

    /**
     * Сохранение студента.
     *
     */
    int save(Student student);

    /**
     * Удаление студента по уникальному номеру.
     *
     */
    int deleteStudentByUniqueNumber(String uniqueNumber);
}
