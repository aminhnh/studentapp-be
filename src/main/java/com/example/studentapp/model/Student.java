package com.example.studentapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    private String id;
    @NonNull
    private String namaDepan;
    private String namaBelakang;
    @NonNull
    private Date tanggalLahir;

}
