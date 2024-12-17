package com.hakimov.office.dao;

import com.hakimov.office.models.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkerDAO {
    private static int WORKER_ID;
    private List<Worker> workerslist;

    {
        // Просто объекты для массовки
        workerslist = new ArrayList<>();
        workerslist.add(new Worker(++WORKER_ID, "Anton", "Gorodetsky", 33, 5, "Assistant",0));
        workerslist.add(new Worker(++WORKER_ID, "Bruce", "Willis", 69, 23, "Developer", 0));
        workerslist.add(new Worker(++WORKER_ID, "Pablo", "Picasso", 91, 68, "Secretary", 0));
        workerslist.add(new Worker(++WORKER_ID, "Magic", "Johnson", 64, 30, "Assistant", 0));

    }

    public List<Worker> updateManagerId(List<Integer> ids, int managerId) {

        for(Integer id : ids) {
            for(Worker worker : workerslist) {
                if(worker.getId() == id) {
                    worker.setManagerId(managerId);
                }
            }
        }
        return null;
    }

    //        List<Worker> listWorkers = getWorkersList().stream()
//                        .filter(worker -> ids.contains(worker.getId()))
//                        .collect(Collectors.toList());
//        listWorkers.stream().map(worker -> {
//            worker.setManagerId(managerId);
//            return worker;
//        }).collect(Collectors.toList());
//        updateWorkersList(listWorkers);
//        System.out.println(listWorkers);

    public List<Worker> getWorkersList() {
        return workerslist;
    }

    public Worker show(int id) {
        for(Worker worker : workerslist) {
            if(worker.getId() == id) {
                return worker;
            }
        }
        return null;
    }

    public void save(Worker worker) {
        worker.setId(++WORKER_ID);
        workerslist.add(worker);
    }

    public void update (int id, Worker updatedWorker) {
        Worker workerToBeUpdated = show(id);

        workerToBeUpdated.setName(updatedWorker.getName());
        workerToBeUpdated.setSurname(updatedWorker.getSurname());
        workerToBeUpdated.setAge(updatedWorker.getAge());
        workerToBeUpdated.setExperience(updatedWorker.getExperience());
        workerToBeUpdated.setSpecialization(updatedWorker.getSpecialization());
        workerToBeUpdated.setManagerId(updatedWorker.getManagerId());

    }

//    public void updateWorkersList (List<Worker> workers) {
//
//        for(Worker worker : workers) {
//            update(worker.getId(), worker);
//        }
//    }

    public void delete(int id) {
        workerslist.removeIf(worker -> worker.getId() == id);
    }

}
