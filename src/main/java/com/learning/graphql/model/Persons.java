package com.learning.graphql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PERSONS")
public class Persons {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name="phone_no", nullable = false)
    private String phoneNo;
}
