package com.hakimov.weapons.dao;

import com.hakimov.weapons.models.Weapon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeaponDAO {
    private static int WEAPONS_COUNT;
    private List<Weapon>weaponslist;

    {
        weaponslist = new ArrayList<>();

        weaponslist.add(new Weapon(++ WEAPONS_COUNT, "Desert Eagle", "gun", 9));
        weaponslist.add(new Weapon(++ WEAPONS_COUNT, "Smith&Wesson Model 19", "revolver", 6));

    }

    // получить список всего оружия
    public List<Weapon> index () {
        return weaponslist;
    }

    // получить объект weapon по id
    public Weapon show(int id) {
        return weaponslist.stream().filter(weapon -> weapon.getId() == id).findAny().orElse(null);
    }

    // записать объект weapon в weaponslist
    public void save(Weapon weapon) {
        weapon.setId(++WEAPONS_COUNT);
        weaponslist.add(weapon);
    }

    // обновить поля объекта weapon
    public void update (int id ,Weapon updatedWeapon) {
        Weapon weaponToBeUpdated = show(id);

        weaponToBeUpdated.setName(updatedWeapon.getName());
        weaponToBeUpdated.setType(updatedWeapon.getType());
        weaponToBeUpdated.setMagazineSize(updatedWeapon.getMagazineSize());
    }

    // удалить объект weapon
    public void delete (int id) {
        weaponslist.removeIf(weapon -> weapon.getId() == id);
    }
}
