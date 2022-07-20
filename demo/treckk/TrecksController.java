package com.example.demo.treckk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrecksController {
    @Autowired
    TrecksService trecksService;


    @GetMapping("/viewAlltrails")
    public ResponseEntity<?> viewTrails() {
        return ResponseEntity.status(200)
                .header("message", "all trails found")
                .body(trecksService.ViewTrails());
    }

    @PostMapping("/enterTrail")
    public ResponseEntity <?> enterTrail(@RequestBody Trecks trecks) {
        trecksService.enterTrail(trecks);
        return ResponseEntity.status(200)
                .header("message", "record saved")
                .body("Added trail with id: " + trecks.getId());
    }


}
