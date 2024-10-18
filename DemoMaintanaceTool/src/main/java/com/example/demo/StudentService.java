package com.example.demo;

public interface StudentService {

    Student createStudent(StudentDTO studentDTO);

    Student findStudentById(int studentId);

    Student updateStudentById(int studentId, StudentDTO studentDTO);

    void deleleStudentById(int studentId);

}
