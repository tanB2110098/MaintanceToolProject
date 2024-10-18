package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentDTO studentDTO) {

        // convert student dto to student
        Student student = Student.builder()
                .name(studentDTO.getName())
                .age(studentDTO.getAge())
                .build();

        // save new student
        return studentRepository.save(student);

    }

    @Override
    public Student findStudentById(int studentId) {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Student does not exist!!")
        );
    }

    @Override
    public Student updateStudentById(int studentId, StudentDTO studentDTO) {

        // load updating student
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Student does not exist!!")
        );


        // update student
        student.setAge(studentDTO.getAge());
        student.setName(studentDTO.getName());

        // save updating to db
        return studentRepository.save(student);
    }

    @Override
    public void deleleStudentById(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
