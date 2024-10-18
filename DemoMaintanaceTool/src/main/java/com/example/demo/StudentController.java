package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @PostMapping("")
    public ResponseEntity<Student> createStudent(
            @RequestBody StudentDTO studentDTO
    ) {
        Student student =  studentService.createStudent(studentDTO);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> findStudentById(
            @PathVariable("studentId") int studentId
    ) {
       try {
           Student student =  studentService.findStudentById(studentId);
           return ResponseEntity.ok().body(student);
       } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> updateStudentById(
            @PathVariable("studentId") int studentId,
            @RequestBody StudentDTO studentDTO
    ) {

        try {
            Student student = studentService.updateStudentById(studentId, studentDTO);
            return ResponseEntity.ok().body(student);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(
            @PathVariable("studentId") int studentId
    ) {
        studentService.deleleStudentById(studentId);
    }

}
