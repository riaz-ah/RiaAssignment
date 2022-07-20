package com.example.demo.treckk;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrecksService {

@Autowired
    private TrecksRepository repository;

    public List<Trecks> ViewTrails() {return repository.findAll();
    }

    public String enterTrail( Trecks trecks ) {
        repository.save(trecks);
        return "Added trail with id: " + trecks.getId();
    }
}
