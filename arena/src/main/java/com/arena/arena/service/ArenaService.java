package com.arena.arena.service;

import com.arena.arena.model.Arena;
import com.arena.arena.model.UpdateArena;

import java.util.List;
import java.util.UUID;

public interface ArenaService {
    void create(Arena arena);
    void update(UpdateArena arena, UUID arenaid);
    Arena getArenaDetails( UUID arenaId);
    List<Arena> getAll();
}
