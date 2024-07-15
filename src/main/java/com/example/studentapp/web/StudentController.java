package com.example.studentapp.web;

import com.example.studentapp.model.Student;
import com.example.studentapp.model.StudentRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/student")
    Collection<Student> student() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    ResponseEntity<?> getStudent(@PathVariable String id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/student")
    ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) throws URISyntaxException {
        log.info("Request to create student: {}", student);
        Student result = studentRepository.save(student);
        return ResponseEntity.created(new URI("/api/student/" + result.getId()))
                .body(result);
    }

    @PutMapping("/student/{id}")
    ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
        log.info("Request to update student: {}", student);
        Student result = studentRepository.save(student);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        log.info("Request to delete student: {}", id);
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
