package com.hakimov.office.controllers;

import com.hakimov.office.dao.ManagerDAO;
import com.hakimov.office.dao.WorkerDAO;
import com.hakimov.office.models.Manager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/managers")
public class ManagerController {

    private ManagerDAO managerDAO;
    private WorkerDAO workerDAO;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("managers", managerDAO.index());
        return "employees/managers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("manager", managerDAO.show(id));
        model.addAttribute("workers", workerDAO.getWorkersList());
        return "employees/managers/show";
    }

    @GetMapping("/new")
    public String newManager(@ModelAttribute Manager manager, Model model) {
        model.addAttribute("workerslist", workerDAO.getWorkersList());
        return "employees/managers/new";
    }

    @PostMapping()
    public String create (@ModelAttribute Manager manager) {
        managerDAO.save(manager);
        return "redirect:/managers";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("manager", managerDAO.show(id));
        model.addAttribute("workerslist", workerDAO.getWorkersList());
        return "employees/managers/edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("manager") Manager manager, @PathVariable("id") int id) {
        managerDAO.update(id, manager);
        return "redirect:/managers";
    }

    // Переход на страницу для добавления работников
    @GetMapping("/{id}/add_worker")
    public String addWorker(@PathVariable("id") int id, Model model) {
        model.addAttribute("manager", managerDAO.show(id));
        model.addAttribute("workerslist", workerDAO.getWorkersList());
        return "employees/managers/add_worker";
    }

    @PatchMapping("/{id}/add")
    public String updateWorkerlist (@ModelAttribute("manager") Manager manager) {
        managerDAO.addWorkers(manager);
        return "redirect:/managers";
    }


    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id) {
        managerDAO.delete(id);
        return "redirect:/managers";
    }

}

