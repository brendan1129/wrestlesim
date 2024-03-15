package com.bnh.wrestlim.models;


import com.bnh.wrestlim.enums.MoveType;
import com.bnh.wrestlim.enums.WrestlerLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// Basically just a wrapper for different types of moves
// MoveType can be used do determine what the result of the move is
// E.g. If it's a submission hold, there needs to be a comeback, submit, or reversal that comes next
// If it's a simple strike, the deliverer can maintain momentum or it can turn back to their opponent.
public class WrestlingMove {
    private String name;
    private MoveType moveType;
    private WrestlerLocation recipientOrigin, recipientFinal, delivererOrigin, delivererFinal;
    private int damage;
}
