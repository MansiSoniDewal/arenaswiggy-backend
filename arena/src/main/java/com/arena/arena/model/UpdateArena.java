package com.arena.arena.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateArena {
    private String arenaName;
    private int health;
    private int strength;
    private int attack;
}
