package com.bnh.wrestlim.models;

import com.bnh.wrestlim.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wrestler {

    // Descriptive Elements
    @Id
    private String id;
    private String name;
    private String ringName;
    private String description;
    private Gender gender;
    private int weight;
    private LocalDate birthDate;
    private String hometown;
    private String imageUrl;

    // Wrestling-specific attributes
    private WrestlingStyle wrestlingStyle;
    private Faction faction;
    private int wins;
    private int losses;
    private int draws;
    private int titleReigns;
    private Championship currentChampionship;
    private CardLevel cardLevel;
    private Federation currentFed;
    // Moveset Specific attributes
    private List<String> finisherMoveList;
    private List<String> signatureMoveList;
    private List<String> moveList;
    private List<String> tauntList;

    // Match Effectors ( combine with wrestlingStyle to create gameplay scenarios )
    int speed; // rate of progression to next move, likelihood to hit light attacks increases
    int agility; // Ability to dodge, improves counter likelihood
    int strength; // Increases move damage. Higher Strength = More capable of heavy attacks against more classes
    int stamina; // Ability to hit multiple moves in succession.
    int tolerance; // Like health or defense. Decreases move damage when receiving one.

    // Additional custom objects
    private List<Rivalry> rivalries; // Who they're against
    private List<Wrestler> tagTeamPartners; // Who they can tag with
    private List<MatchData> matchHistory; // Wrestler history

    // Methods for simulating matches and actions
    // TODO make method
    // public void performMove(Move move, Wrestler opponent) {
        // Logic for applying the move and updating match state
    // }
    // ...other methods for match interactions
}
