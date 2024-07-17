package com.hakimov.office.dao;

import com.hakimov.office.models.Manager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerDAO {
    private static int MANAGER_ID;
    private List<Manager> managerslist;
    private List<Integer> workersId;

    {
        //// Просто объекты для массовки
        managerslist = new ArrayList<>();
        managerslist.add(new Manager(++MANAGER_ID, "Ilon", "Mask", 53, 25, workersId = new ArrayList<>()));
        managerslist.add(new Manager(++MANAGER_ID, "Domenico", "Trezzini", 64, 33,workersId = new ArrayList<>()));
    }

    public List<Manager> index () {
        return managerslist;
    }

    public Manager addWorkers (Manager manager, int workersId) {
        manager.getWorkersId().add(workersId);
        return manager;
    }

    public Manager show(int id) {
        for (Manager manager : managerslist) {
            if (manager.getId() == id) {
                System.out.println(manager.getWorkersId());
                return manager;
            }
        }
        return null;
    }

    public void save(Manager manager) {
        manager.setId(++MANAGER_ID);
        managerslist.add(manager);
    }

    public void update(int id, Manager updatedManager) {
        Manager managerToBeUpdated = show(id);

        managerToBeUpdated.setName(updatedManager.getName());
        managerToBeUpdated.setSurname(updatedManager.getSurname());
        managerToBeUpdated.setAge(updatedManager.getAge());
        managerToBeUpdated.setExperience(updatedManager.getExperience());
        managerToBeUpdated.setWorkersId(updatedManager.getWorkersId());

    }

    public void delete(int id) {
        managerslist.removeIf(manager -> manager.getId() == id);
    }
}
