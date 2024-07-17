package com.hakimov.office.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Setter
@Getter
public class Manager {

    private int id;
    private String name;
    private String surname;
    private int age;
    private int experience;
    private List workersId;

}
