package com.bnh.wrestlim.models;

import com.bnh.wrestlim.enums.GroupLevel;
import com.bnh.wrestlim.enums.Orientation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Faction {
    private String name;
    private List<Wrestler> members;
    private Orientation orientation;
    private GroupLevel groupLevel;
}
