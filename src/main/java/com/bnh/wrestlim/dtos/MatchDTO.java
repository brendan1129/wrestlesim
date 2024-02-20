package com.bnh.wrestlim.dtos;


import com.bnh.wrestlim.enums.MatchStipulation;
import com.bnh.wrestlim.enums.MatchType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class MatchDTO {

    private List<String> participants;

    private MatchStipulation stipulation;

    private MatchType type;

    private int segments;
}
