package com.bnh.wrestlim.controllers;

import com.bnh.wrestlim.models.Wrestler;
import com.bnh.wrestlim.services.WrestlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wrestlers")
@Document(collection = "wrestler")
@CrossOrigin
public class WrestlerController {
    @Autowired
    WrestlerService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllWrestlers() {
        return ResponseEntity.ok(service.getAllWrestlers());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getWrestler(@PathVariable String id) {
        return ResponseEntity.ok(service.getWrestler(id));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createWrestler(@RequestBody Wrestler wrestler) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createWrestler(wrestler));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateWrestler(@PathVariable String id, @RequestBody Wrestler wrestler ) {
        // Return a response with the updated wrestler and a success status code
        return ResponseEntity.ok(service.updateWrestler(wrestler, id));
    }
}
