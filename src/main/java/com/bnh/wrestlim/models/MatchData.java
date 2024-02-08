package com.bnh.wrestlim.models;

import com.bnh.wrestlim.enums.MatchStipulation;
import com.bnh.wrestlim.enums.MatchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchData {
    private boolean DQEnd;
    private boolean forChampionship;
    private List<Wrestler> participants;
    private List<Wrestler> winners, losers;
    private MatchType matchType;
    private MatchStipulation stipulation;
    private LocalDate date;
}
