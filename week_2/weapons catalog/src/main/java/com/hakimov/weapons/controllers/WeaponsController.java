package com.hakimov.weapons.controllers;

import com.hakimov.weapons.dao.WeaponDAO;
import com.hakimov.weapons.models.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weapons")
public class WeaponsController {

    private WeaponDAO weaponDAO;

    @Autowired
    public WeaponsController(WeaponDAO weaponDAO) {
        this.weaponDAO = weaponDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("weapons", weaponDAO.index());
        return "weapons/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("weapon", weaponDAO.show(id));
        return "weapons/show";
    }

    // Открываем страницу с формой и передаем туда пустой объект
    @GetMapping("/new")
    public String newWeapon(@ModelAttribute("weapon") Weapon weapon) {
        return "weapons/new";
    }

    // Сoхраняем объект из формы
    @PostMapping()
    public String create(@ModelAttribute("weapon") Weapon weapon) {
        weaponDAO.save(weapon);
        return "redirect:/weapons";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id ) {
        model.addAttribute("weapon", weaponDAO.show(id));
        return "weapons/edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("weapon") Weapon weapon, @PathVariable("id") int id) {
        weaponDAO.update(id, weapon);
        return "redirect:/weapons";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        weaponDAO.delete(id);
        return "redirect:/weapons";
    }




}
