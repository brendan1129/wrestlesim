package com.bnh.wrestlim.controllers;

import com.bnh.wrestlim.dtos.MatchDTO;
import com.bnh.wrestlim.models.MatchEngine;
import com.bnh.wrestlim.models.Wrestler;
import com.bnh.wrestlim.repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    WrestlerRepository repository;

    /***
     *  MatchDTO
     *     private List<String> participants;
     *     private MatchStipulation stipulation;
     *     private MatchType type;
     *     private int segments;
     */
    @PostMapping("/start")
    public ResponseEntity<?> startWrestlingMatch(@RequestBody MatchDTO dto) {
        Optional<Wrestler> a = repository.findById(dto.getParticipants().get(0));
        Optional<Wrestler> b = repository.findById(dto.getParticipants().get(1));

        if( a.isEmpty() || b.isEmpty() ) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<Wrestler> participants = new ArrayList<>();
            participants.add(a.get());
            participants.add(b.get());
            MatchEngine match = new MatchEngine(participants, dto.getType(), dto.getStipulation(), dto.getSegments());
            match.startMatch();
            String lineByLineBody = String.join("\n", match.getMatchText());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(lineByLineBody);
        }
    }
}
