package com.bnh.wrestlim.models;

import com.bnh.wrestlim.enums.CardLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Championship {
    private String name;
    private CardLevel level;
    private List<Wrestler> history; // Who had the belt
}
