package com.example.studentapp;

import com.example.studentapp.model.Student;
import com.example.studentapp.model.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final StudentRepository repository;

    public Initializer(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Student student1 = Student.builder()
                .id("22505050PA12345")
                .namaDepan("John")
                .namaBelakang("Doe")
                .tanggalLahir(dateFormat.parse("2000-05-15"))
                .build();

        Student student2 = Student.builder()
                .id("23505050PA12346")
                .namaDepan("Jane")
                .tanggalLahir(dateFormat.parse("1999-12-30"))
                .build();

        Student student3 = Student.builder()
                .id("24505050PA12347")
                .namaDepan("Alice")
                .namaBelakang("Smith")
                .tanggalLahir(dateFormat.parse("2001-03-10"))
                .build();

        Student student4 = Student.builder()
                .id("25505050PA12348")
                .namaDepan("Bob")
                .namaBelakang("Johnson")
                .tanggalLahir(dateFormat.parse("1998-07-25"))
                .build();

        Student student5 = Student.builder()
                .id("26505050PA12349")
                .namaDepan("Carol")
                .namaBelakang("White")
                .tanggalLahir(dateFormat.parse("2002-01-05"))
                .build();

        repository.save(student1);
        repository.save(student2);
        repository.save(student3);
        repository.save(student4);
        repository.save(student5);

        repository.findAll().forEach(System.out::println);
    }
}