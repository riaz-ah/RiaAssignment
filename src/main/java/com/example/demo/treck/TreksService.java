package com.example.demo.treck;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreksService {

    private TreksRepository repository;

    public TreksService(@Autowired TreksRepository treksRepository){
        this.repository = treksRepository;
    }

    public List<Treks> ViewTrails() {
        return repository.findAll();
    }

    public Treks enterTrail(Treks trecks) {
        return repository.save(trecks);
//        return "Added trail with id: " + treks.getId();
    }

    public List<Treks> getTrailByTrekId(String id) {
        return repository.findByTrekId(id);
    }

    public List<Treks> findTrail(String name) {
        return repository.findByName(name);
//        object
    }



//    public List<Treks> getTrail(String id) {
//        return repository.findById();
//    }
}
