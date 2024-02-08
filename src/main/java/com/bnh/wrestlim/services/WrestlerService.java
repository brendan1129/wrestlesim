package com.bnh.wrestlim.services;

import com.bnh.wrestlim.models.Wrestler;
import com.bnh.wrestlim.repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WrestlerService {
    @Autowired
    WrestlerRepository repository;
    public List<Wrestler> getAllWrestlers() {
        return repository.findAll();
    }
    public Wrestler getWrestler(String id) {
        Optional<Wrestler> wrestler = repository.findById(id);
        if(wrestler.isEmpty()) {
            throw new NoSuchElementException();
        }
        return wrestler.get();
    }
    public Wrestler createWrestler(Wrestler w) {
        return repository.save(w);
    }
    public Wrestler updateWrestler(Wrestler w, String id) {
        // Retrieve the existing wrestler from the database
        Optional<Wrestler> existingWrestler = repository.findById(id);
        if(existingWrestler.isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
// Update fields using values from the provided wrestler object 'w':
            existingWrestler.get().setName(w.getName());
            existingWrestler.get().setRingName(w.getRingName());
            existingWrestler.get().setDescription(w.getDescription());
            existingWrestler.get().setGender(w.getGender());
            existingWrestler.get().setWeight(w.getWeight());
            existingWrestler.get().setBirthDate(w.getBirthDate());  // Assuming LocalDate objects
            existingWrestler.get().setHometown(w.getHometown());
            existingWrestler.get().setImageUrl(w.getImageUrl());
            existingWrestler.get().setWrestlingStyle(w.getWrestlingStyle());
// ... update other fields as needed (finisherMoveList, signatureMoveList, etc.)
// Example for updating a list field:
            existingWrestler.get().getFinisherMoveList().clear();  // Clear existing moves
            existingWrestler.get().getFinisherMoveList().addAll(w.getFinisherMoveList());
            existingWrestler.get().getSignatureMoveList().clear();  // Clear existing moves
            existingWrestler.get().getSignatureMoveList().addAll(w.getSignatureMoveList());
            existingWrestler.get().getMoveList().clear();  // Clear existing moves
            existingWrestler.get().getMoveList().addAll(w.getMoveList());

            existingWrestler.get().setFaction(w.getFaction());
            existingWrestler.get().setWins(w.getWins());
            existingWrestler.get().setLosses(w.getLosses());
            existingWrestler.get().setDraws(w.getDraws());
            existingWrestler.get().setTitleReigns(w.getTitleReigns());
            existingWrestler.get().setCurrentChampionship(w.getCurrentChampionship());
            existingWrestler.get().setCardLevel(w.getCardLevel());

            existingWrestler.get().getRivalries().clear();  // Clear existing moves
            existingWrestler.get().getRivalries().addAll(w.getRivalries());
            existingWrestler.get().getTagTeamPartners().clear();  // Clear existing moves
            existingWrestler.get().getTagTeamPartners().addAll(w.getTagTeamPartners());
            existingWrestler.get().getMatchHistory().clear();  // Clear existing moves
            existingWrestler.get().getMatchHistory().addAll(w.getMatchHistory());


            return repository.save(existingWrestler.get());
        }

    }
}
