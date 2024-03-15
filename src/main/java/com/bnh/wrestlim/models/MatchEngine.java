package com.bnh.wrestlim.models;

import com.bnh.wrestlim.enums.MatchStipulation;
import com.bnh.wrestlim.enums.MatchType;
import lombok.Data;
import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

@Data
public class MatchEngine {

    MatchData matchData;

    Wrestler wrestlerA, wrestlerB; // Singles match

    boolean aGrappled, bGrappled; // Decides who has the advantage from move to move

    List<String> matchText;

    List<WrestlingMove> moves;

    int numSegments;
    public MatchEngine(List<Wrestler> participants, MatchType type, MatchStipulation stipulation, int segments) {
        this.numSegments = segments;
        matchData = new MatchData();
        matchData.setParticipants(participants);
        matchData.setMatchType(type);
        matchData.setStipulation(stipulation);
        matchData.setDate(LocalDate.now());
        switch (type) {
            case SINGLES -> {
                wrestlerA = participants.get(0);
                wrestlerB = participants.get(1);
            }
            default -> {
            }
        }
        matchText = new ArrayList<>();
        moves = new ArrayList<>();
    }

    /** First approach:
     *  Wrestling matches are stories, a performance
     *  This simulator will basically fabricate that story on the fly using known tropes within pro wrestling.
     *  There are also different calibers of matches.
     *  Not every match should be a 45-minute barn burner.
     *  To enforce this, matches will have a numSegments between 3 and 12
     *  Each segment can be a series of moves, or an event such as wrestler getting distracted
     *  In-between segments, there will simply be rest holds. The last segment should be the finishing sequence.
     */
    public void startMatch() {
        for(int i = 0; i <= numSegments; i++) {
            simulateSegment(i, numSegments);
        }
    }
    private void simulateSegment(int currentSeg, int maxSegs) {
        if( currentSeg <= maxSegs / 3 ) { // Beginning third of match
            beginningSegments(currentSeg);
        }
        else if (currentSeg >= maxSegs / 3 && currentSeg <= maxSegs - (maxSegs/3)) { // Middle of match
            beginningSegments(currentSeg);
        }
        else if (currentSeg >= maxSegs - (maxSegs/3) && currentSeg < maxSegs) { // Final third of match
            beginningSegments(currentSeg);
        }
    }

    private int makeDecision() {
        return new Random().nextInt(0, 2);
    }
    private int calculateLength(int a, int b) {
        if (a < b) {
            return new Random().nextInt(a, b+1);
        }
        else if (a > b) {
            return new Random().nextInt(b, a+1);
        }
        else {
            return a;
        }
    }
    private int combineDecisions(int a, int b) {
        if(a == b) {
            return new Random().nextInt(0, 2);
        }
        else if( a == 1 ) {
            return 0;
        }
        else if( b == 1 ) {
            return 1;
        }
        else {
            return 2;
        }
    }
    private void beginningSegments(int currentSeg) {
        // Calculate length of segment, how many moves take place
        int segmentLength = calculateLength(wrestlerA.stamina, wrestlerB.stamina);
        matchText.add("In segment: " + currentSeg + ". The current segment length is: " + segmentLength + "\n");
        for(int i = 0; i < segmentLength; i++) {
            matchText.add("We are currently at move: " + (i+1) + "\n");

            // Wrestler A makes a decision, Wrestler B makes a decision
            // 0: Grapple, 1: Attack, or 2: Taunt
            // One of 3, with Rock Paper Scissor balancing, if same, then wrestler attributes take over.
            int decisionA = makeDecision();
            int decisionB = makeDecision();

            // 0: decision A wins, 1: decision B wins, 2: Attribute-controlled decision
            int result = combineDecisions(decisionA, decisionB);

            if (result == 0) {
                matchText.add("Wrestler A wins decision \n");
                switch (decisionA) {
                    case 0 -> {
                        // grapple ( preserves stamina )
                        if(aGrappled) {
                            aGrappled = false;
                            // reverse grapple into grapple
                            bGrappled = true;
                            matchText.add("Wrestler A reverses the grapple \n");
                        }
                        else {
                            if(bGrappled) {
                                // submission attempt
                                matchText.add("Wrestler A goes for a submission on Wrestler B\n");
                                bGrappled = false;
                            }
                            else {
                                // grapple wrestler b
                                bGrappled = true;
                                matchText.add("Wrestler A grapples Wrestler B \n");
                            }
                        }
                    }
                    case 1 -> {
                        // attack ( uses stamina but deals damage )
                        if(aGrappled) {
                            aGrappled = false;
                            matchText.add("Wrestler A reverses the grapple and attacks Wrestler B \n");
                            // reverse grapple
                        }
                        else {
                            // regular attack
                            matchText.add("Wrestler A hits Wrestler B with a move \n");
                        }
                    }
                    case 2 -> {
                        // taunt ( deals no damage but increases tolerance )
                        if(aGrappled) {
                            aGrappled = false;
                            matchText.add("Wrestler A reverses the grapple and shows off for the crowd \n");
                        }
                    }
                    default -> {
                        //
                    }
                }
            }
            else if (result == 1) {
                // decision B wins
                matchText.add("Wrestler B wins decision \n");
                switch (decisionB) {
                    case 0 -> {
                        // grapple ( preserves stamina )
                        if(bGrappled) {
                            matchText.add("Wrestler B reverses the grapple \n");
                            // reverse grapple into grapple
                            bGrappled = false;
                            aGrappled = true;
                        }
                        else {
                            if(aGrappled) {
                                // submission attempt
                                matchText.add("Wrestler B goes for a submission \n");
                                aGrappled = false;
                            }
                            else {
                                // just grapple wrestler a
                                matchText.add("Wrestler B grabs Wrestler A \n");
                                aGrappled = true;
                            }
                        }
                    }
                    case 1 -> {
                        // attack ( uses stamina but deals damage )
                        if(bGrappled) {
                            bGrappled = false;
                            // light reversal out of grapple
                            matchText.add("Wrestler B reverses the grapple and attacks Wrestler A \n");
                        }
                        else {
                            // regular attack attack
                            matchText.add("Wrestler B attacks Wrestler A \n");
                        }
                    }
                    case 2 -> {
                        // taunt ( deals no damage but increases tolerance )
                        if(bGrappled) {
                            bGrappled = false;
                            matchText.add("Wrestler B reverses the grapple and panders to the crowd \n");
                        }
                    }
                    default -> {

                    }
                }
            }
        }
    }
}
