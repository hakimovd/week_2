package com.hakimov.office.models;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Manager {

    private int id;
    private String name;
    private String surname;
    private int age;
    private int experience;
    private List<Integer> workersId;

}
