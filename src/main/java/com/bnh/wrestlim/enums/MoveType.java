package com.bnh.wrestlim.enums;

// Informs the match engine what the next spot is, or what else needs to happen within the spot
public enum MoveType {
    STRIKE, // Overhand Right Punch, DropKick, Flying Elbow
    SLAM, // Suplexes, Powerbombs, DDTs, normally end with receiver being grounded
    SUBMISSION, // Self Explanatory
    SPLASH, // Anything that involves a wrestler bringing their weight down on another wrestler
    // e.g. leg drops, frog splash, moonsaults
    THROW, // e.g. Huracanrana, Irish Whip, non damage dealing but move the recipients location.
    HOLD // e.g. rear choke hold, mostly used for lowpoints in the eb and flow of a match.
}
