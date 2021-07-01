package com.example.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
    @CreationTimestamp
    private LocalDate dateAdd;
    private String contentTask;
    private int checkbox;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;


//    public Task(Long id, Date deadline, LocalDate dateAdd, String contentTask, int checkbox) {
//        this.id = id;
//        this.deadline = deadline;
//        this.dateAdd = dateAdd;
//        this.contentTask = contentTask;
//        this.checkbox = checkbox;
//    }
//
//    public Task(Date deadline, LocalDate dateAdd, String contentTask, int checkbox){
//    }
//
//    public Task(Long id, Date deadline, String contentTask, int checkbox) {
//
//    }
}


