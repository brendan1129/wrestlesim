package com.bnh.wrestlim.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rivalry {
    private boolean oneOnOne;
    private Wrestler antagonist, protagonist;
    private List<Wrestler> antagonistGroup, protagonistGroup;
    private int duration; // in weeks
}
