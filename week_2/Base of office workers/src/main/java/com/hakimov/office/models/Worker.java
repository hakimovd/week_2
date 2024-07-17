package com.hakimov.office.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Setter
@Getter
public class Worker {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int experience;
    private String specialization;
    private int managerId;

}
