package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String gitHub;
    private String start;
    private Integer java;
    private Integer bestpractice;
    private Integer tdd;
    private Integer question;
    private Integer hibernate;
    private Integer html;
    private Integer jsp;
    private Integer thymeleaf;
    private Integer git;
    private Integer checkbox;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Set<Task> tasks = new HashSet<Task>();

    public Person(Long id, String firstName, String lastName, String gitHub, String start, Integer java, Integer bestpractice, Integer tdd, Integer question, Integer hibernate, Integer html, Integer jsp, Integer thymeleaf, Integer git, Integer checkbox) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gitHub = gitHub;
        this.start = start;
        this.java = java;
        this.bestpractice = bestpractice;
        this.tdd = tdd;
        this.question = question;
        this.hibernate = hibernate;
        this.html = html;
        this.jsp = jsp;
        this.thymeleaf = thymeleaf;
        this.git = git;
        this.checkbox = checkbox;
        this.tasks = tasks;
    }

    public Person(String firstName, String lastName, String gitHub, String start, Integer java, Integer bestpractice, Integer tdd, Integer question, Integer hibernate, Integer html, Integer jsp, Integer thymeleaf, Integer git, Integer checkbox) {
    }
}
