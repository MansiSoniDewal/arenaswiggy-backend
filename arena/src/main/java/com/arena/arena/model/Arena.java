package com.arena.arena.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "arena")
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID arenaid;
    private String arenaname;
    private int health;
    private int strength;
    private int attack;
}
