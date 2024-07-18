package com.hakimov.office.controllers;

import com.hakimov.office.dao.ManagerDAO;
import com.hakimov.office.dao.WorkerDAO;
import com.hakimov.office.models.Worker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/workers")
public class WorkerController {

    private ManagerDAO managerDAO;
    private WorkerDAO workerDAO;

    @GetMapping()
    public String index (Model model) {
        model.addAttribute("workers", workerDAO.getWorkersList());
        return "employees/workers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("worker", workerDAO.show(id));
        model.addAttribute("manager", managerDAO.show(workerDAO.show(id).getManagerId()));
        return "employees/workers/show";
    }

    @GetMapping("/new")
    public String newWorker(@ModelAttribute Worker worker, Model model) {
        model.addAttribute("managerslist", managerDAO.index());
        return "employees/workers/new";
    }

    @PostMapping()
    public String create (@ModelAttribute Worker worker) {
        workerDAO.save(worker);
        return "redirect:/workers";
    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable("id") int id, Model model) {
        model.addAttribute("worker", workerDAO.show(id));
        model.addAttribute("managerslist", managerDAO.index());
        return "employees/workers/edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("worker") Worker worker, @PathVariable("id") int id) {
        workerDAO.update(id, worker);
        return "redirect:/workers";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id) {
        workerDAO.delete(id);
        return "redirect:/workers";
    }
}
