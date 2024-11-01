package com.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/**
 * Класс представляет собой модель учетной записи в системе.
 * Учетная запись связана с студентом.
 */

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Имя студента.
     */
    @Column(name = "firstname", nullable = false)
    private String firstName;

    /**
     * Фамилия студента.
     */
    @Column(name = "lastname", nullable = false)
    private String lastName;

    /**
     * Отчество студента.
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Дата рождения студента.
     */
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    /**
     * Группа студента.
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * Уникальный номер студента.
     */
    @Column(name = "unique_number", nullable = false, unique = true)
    private String uniqueNumber;
}
