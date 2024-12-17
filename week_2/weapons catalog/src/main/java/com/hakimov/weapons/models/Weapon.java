package com.hakimov.weapons.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weapon {
    private int id;
    private String name;
    private String type;
    private int magazineSize;

    public Weapon() {
    }

    public Weapon(int id, String name, String type, int magazineSize) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.magazineSize = magazineSize;
    }
}
