package com.example.demo.treckk;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrecksService {



    private TrecksRepository repository;

    public TrecksService(@Autowired TrecksRepository trecksRepository){
        this.repository = trecksRepository;


    }

    public List<Trecks> ViewTrails() {
        return repository.findAll();
    }

    public Trecks enterTrail(Trecks trecks) {
        return repository.save(trecks);
//        return "Added trail with id: " + trecks.getId();
    }

    public List<Trecks> getTrailByTreckId(String id) {
        return repository.findByTreckId(id);
    }

    public List<Trecks> findTrail(String name) {
        return repository.findByName(name);
//        object
    }


//    public List<Trecks> getTrail(String id) {
//        return repository.findById();
//    }
}
