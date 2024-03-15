package com.bnh.wrestlim.models;

import com.bnh.wrestlim.enums.CommentaryTeam;
import com.bnh.wrestlim.enums.DialogueType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class DialogueManager {
    private List<String> matchText;

    private String wrestlerName1, wrestlerName2;

    private CommentaryTeam team;

    public DialogueManager(String wrestlerName1, String wrestlerName2, CommentaryTeam team) {
        this.matchText = new ArrayList<>();
        this.wrestlerName1 = wrestlerName1;
        this.wrestlerName2 = wrestlerName2;
        this.team = team;
    }
    /**
     * TODO:
     * - Generate commentary on the match based on commentary style
     * - Generate commentary on the storyline based on commentary style
     * - sprinkle in storyline text intermittently
     */

    public void deliver(DialogueType type, CommentaryTeam team, String moveName, String deliverer, String receiver) {
        switch(type) {
            case START -> {
                addStartText(team);
            }
            case ATTACK -> {
                addAttackText(team, moveName, deliverer, receiver);
            }
            case TAUNT -> {
                addTauntText(team, deliverer);
            }
            case REVERSAL -> {
                addReversalText(team, moveName, deliverer, receiver);
            }
            case GRAPPLE -> {
                addGrappleText(team, deliverer, moveName);
            }
            case SUBMISSION -> {
                addSubmissionText(team, deliverer, receiver);
            }
            case SUBMISSIONBREAK -> {
            }
            case REST -> {
            }
            case SIGNATURE -> {
            }
            case FINISHER -> {
            }
            case NEARFALL -> {
            }
            case PINFALL -> {
            }
            case TAPOUT -> {
            }
        }
    }
    public void addStartText(CommentaryTeam team) {
        switch(team) {
            case GOLDEN -> {
                matchText.add("Monsoon: Welcome back to the squared circle, folks! Joining me as always, the man with a vocabulary as colorful as his suits, the one and only Bobby \"The Brain\" Heenan!");
                matchText.add("Heenan: Greetings, Gorilla. Though I wouldn't call my suits colorful, more like impeccably tailored works of art. Unlike, say, your polyester nightmares. But enough about fashion disasters, the fans are here for some action!");
                matchText.add("Monsoon: Oh, stop it you. Let's get down to business! In our upcoming match, we have..." + wrestlerName1 + " and " + wrestlerName2 + ", two athletes with clashing desires to come away with a win tonight.");

            }
            case ATTITUDE -> {
                matchText.add("JR: Welcome back folks to another evening of professional wrestling. I'm joined by Jerry \"the King\" Lawler to bring you top quality commentary on the matchups.");
                matchText.add("King: Thanks JR, that's right everyone I'm here to bestow my royal opinion upon the subjects. And keeping my eyes out for any puppies!");
                matchText.add("JR: I'll be sure to keep the nonsense at a minimum. Ladies and gentleman we've got quite the match in store for you tonight.");
                matchText.add("King: Oh yeah, these guys " + wrestlerName1 + " and " + wrestlerName2 + " are ready to go at it!");
            }
            case RUTHLESS -> {
                matchText.add("Cole: Welcome to the program, everyone! I'm Michael Cole and the energy is just electric here in the arena. Of course, I'm joined by the legendary \"King\" Jerry Lawler!");
                matchText.add("Lawler: The King is in the building, Cole. Happy to be here tonight and witness some wrestling greatness.");
                matchText.add("Cole: The WWE Universe is electric right now, eagerly anticipating this highly-contested matchup.");
                matchText.add("Lawler: You got that right! The people are going crazy. Everyone's excited to see " + wrestlerName1 + " go up against " + wrestlerName2);
            }
            case REALITY -> {
            }
            case MODERN -> {
            }
        }
    }
    public void addAttackText(CommentaryTeam team, String move, String deliverer, String receiver) {
        switch (team) {

            case GOLDEN -> {
            }
            case ATTITUDE -> {
            }
            case RUTHLESS -> {
                matchText.add("King: YEOW! " + deliverer + " with a vicious " + move + ".");
                matchText.add("Cole: That's certainly going to slow the momentum of " + receiver + ".");
                matchText.add("King: No doubt about it, Cole. " + receiver + " may be down for the count.");
            }
            case REALITY -> {
            }
            case MODERN -> {
            }
        }

    }
    public void addTauntText(CommentaryTeam team, String taunter) {
        switch(team) {
            case GOLDEN -> {
            }
            case ATTITUDE -> {
            }
            case RUTHLESS -> {
                matchText.add("Cole: And now " + taunter + " gloating to the WWE Universe.");
                matchText.add("King: Now he's got to be careful here. Can't lose focus on the match too much, or it'll bite you in the behind.");
            }
            case REALITY -> {
            }
            case MODERN -> {
            }
        }
    }
    public void addReversalText(CommentaryTeam team, String moveName, String deliverer, String receiver) {
        switch(team){

            case GOLDEN -> {
            }
            case ATTITUDE -> {
            }
            case RUTHLESS -> {
                matchText.add("Cole: And " + deliverer +" with the reversal!" + receiver + " tried to " + moveName + " and it did not connect.");
                matchText.add("Lawler: Oowie! Looks like " + deliverer + " had that scouted a mile away.");
            }
            case REALITY -> {
            }
            case MODERN -> {
            }
        }
    }
    public void addGrappleText(CommentaryTeam team, String deliverer, String move) {
        switch(team) {

            case GOLDEN -> {
            }
            case ATTITUDE -> {
            }
            case RUTHLESS -> {
                matchText.add("Cole: " + deliverer + " able to get a grab on their opponent.");
            }
            case REALITY -> {
            }
            case MODERN -> {
            }
        }
    }
    public void addSubmissionText(CommentaryTeam team, String deliverer, String receiver) {
        switch(team) {

            case GOLDEN -> {
            }
            case ATTITUDE -> {
            }
            case RUTHLESS -> {
                matchText.add("Cole: A submission locked in now as " + deliverer + "looks to make " + receiver + "tap.");
                matchText.add("King: If " + receiver + " isn't careful, the match could be over in a matter of seconds!");
            }
            case REALITY -> {
            }
            case MODERN -> {
            }
        }
    }
    public void addSubBreakText(CommentaryTeam team, String deliverer, String receiver) {
        switch(team) {

            case GOLDEN -> {
            }
            case ATTITUDE -> {
            }
            case RUTHLESS -> {
            }
            case REALITY -> {
            }
            case MODERN -> {
            }
        }
    }
}
