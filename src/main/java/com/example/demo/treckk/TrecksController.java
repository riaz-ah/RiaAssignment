package com.example.demo.treckk;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
public class TrecksController {
    @Autowired
    TreksService treksService;



    @GetMapping("/viewAlltrails")
    public ResponseEntity<?> viewTrails() {
        log.info("Request received to view all trails");
        return ResponseEntity.status(200)
                .header("message", "all trails found")
                .body(treksService.ViewTrails());
    }

    @PostMapping("/enterTrail")
    public ResponseEntity<?> enterTrail(@RequestBody Trecks trecks) {
        log.info("Request received to add a trails");
        treksService.enterTrail(trecks);
        return ResponseEntity.status(200)
                .header("message", "record saved")
                .body("Added trail with id: " + trecks.getId());
    }

    @GetMapping("/findtrecks/{id}")
    public ResponseEntity<?> getTrail(@PathVariable String id) {
        log.info("Request received to find a trek with the given id");
        return ResponseEntity.status(200)
                .header("message", "trail found using id")
                .body(treksService.getTrailByTreckId(id));
    }

    @GetMapping("/findTrecks/")
    public ResponseEntity<?> findTrail(@RequestParam String name) {
        log.info("Request received to find a trek by name");
        return ResponseEntity.status(200)
                .header("message", "trail found using name")
                .body(treksService.findTrail(name));

    }

//    @GetMapping("/findTrecks/{name}")
//    public ResponseEntity<?> findTrail(@PathVariable String name) {
//        return ResponseEntity.status(200)
//                .header("message", "trail found using name")
//                .body(trecksService.findTrail(name));
}
