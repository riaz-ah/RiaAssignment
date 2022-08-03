package com.example.demo.treckk;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.naming.Name;
import java.util.List;

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
    public ResponseEntity<?> enterTrail(@RequestBody Trecks trecks) {
        trecksService.enterTrail(trecks);
        return ResponseEntity.status(200)
                .header("message", "record saved")
                .body("Added trail with id: " + trecks.getId());
    }

    @GetMapping("/findtrecks/{id}")
    public ResponseEntity<?> getTrail(@PathVariable String id) {
        return ResponseEntity.status(200)
                .header("message", "trail found using id")
                .body(trecksService.getTrailByTreckId(id));
    }

    @GetMapping("/findTrecks/")
    public ResponseEntity<?> findTrail(@RequestParam String name) {
        return ResponseEntity.status(200)
                .header("message", "trail found using name")
                .body(trecksService.findTrail(name));

    }

//    @GetMapping("/findTrecks/{name}")
//    public ResponseEntity<?> findTrail(@PathVariable String name) {
//        return ResponseEntity.status(200)
//                .header("message", "trail found using name")
//                .body(trecksService.findTrail(name));
}
